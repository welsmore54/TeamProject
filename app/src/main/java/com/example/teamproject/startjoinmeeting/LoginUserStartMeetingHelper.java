package com.example.teamproject.startjoinmeeting;

import android.content.Context;

import us.zoom.sdk.MeetingService;
import us.zoom.sdk.StartMeetingOptions;
import us.zoom.sdk.StartMeetingParams4NormalUser;
import us.zoom.sdk.ZoomSDK;
import com.example.teamproject.inmeetingfunction.zoommeetingui.ZoomMeetingUISettingHelper;

public class LoginUserStartMeetingHelper {
    private final static String TAG = "LoginUserStartMeetingHelper";

    private static LoginUserStartMeetingHelper mEmailLoginUserStartMeetingHelper;

    private ZoomSDK mZoomSDK;

    private LoginUserStartMeetingHelper() {
        mZoomSDK = ZoomSDK.getInstance();
    }

    public synchronized static LoginUserStartMeetingHelper getInstance() {
        mEmailLoginUserStartMeetingHelper = new LoginUserStartMeetingHelper();
        return mEmailLoginUserStartMeetingHelper;
    }

    public int startMeetingWithNumber(Context context, String meetingNo) {
        int ret = -1;
        MeetingService meetingService = mZoomSDK.getMeetingService();
        if(meetingService == null) {
            return ret;
        }

        StartMeetingOptions opts =ZoomMeetingUISettingHelper.getStartMeetingOptions();
        opts.no_video=false;

        StartMeetingParams4NormalUser params = new StartMeetingParams4NormalUser();
        params.meetingNo = meetingNo;
        return meetingService.startMeetingWithParams(context, params, opts);
    }

    public int startMeetingWithVanityId(Context context, String vanityId) {
        int ret = -1;
        MeetingService meetingService = mZoomSDK.getMeetingService();
        if(meetingService == null) {
            return ret;
        }

        StartMeetingOptions opts = ZoomMeetingUISettingHelper.getStartMeetingOptions();

        StartMeetingParams4NormalUser params = new StartMeetingParams4NormalUser();
        params.vanityID = vanityId;
        return meetingService.startMeetingWithParams(context, params, opts);
    }

    public int startInstanceMeeting(Context context) {
        int ret = -1;
        MeetingService meetingService = mZoomSDK.getMeetingService();
        if(meetingService == null) {
            return ret;
        }

        StartMeetingOptions opts = ZoomMeetingUISettingHelper.getStartMeetingOptions();
        opts.no_video=false;
        opts.no_audio=false;

        return meetingService.startInstantMeeting(context, opts);
    }
}
