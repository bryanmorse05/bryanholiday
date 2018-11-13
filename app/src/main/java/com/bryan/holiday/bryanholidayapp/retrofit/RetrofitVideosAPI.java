package com.bryan.holiday.bryanholidayapp.retrofit;

import com.bryan.holiday.bryanholidayapp.models.VideoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitVideosAPI {

    @GET("echo?user_content_key=27mXAXw3qhqBfqExmB11FAXFbjlOHhH1RngY7Ici0RfpLEpmoVNmnsAcqJboQimW" +
            "HdFXVO6qWlL6UDiE4GgAAO_EzFSuXd2Vm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZE" +
            "nKsbu93Dn_SVPy6NJHh-IUilLyYJ61IS1PFhP2bhjkYSHH5JqvAKWeN5K2M4JFlM20aSSP2R0-j5&lib=MmJ" +
            "vZhwKEz1FYIlWjxCkvq-IJw8LXah2a")
    Call<List<VideoModel>> getEvents();

}
