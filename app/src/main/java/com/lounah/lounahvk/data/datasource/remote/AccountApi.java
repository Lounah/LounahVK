package com.lounah.lounahvk.data.datasource.remote;

import android.support.annotation.NonNull;

import com.lounah.lounahvk.data.entities.BannedAccount;
import com.lounah.lounahvk.data.entities.Counters;
import com.lounah.lounahvk.data.entities.ProfileInfo;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AccountApi {

    @POST("account.ban")
    Completable ban(
            @Query("owner_id") final int ownerId,
            @Query("access_token") @NonNull final String accessToken,
            @Query("v") @NonNull final String apiVersion
    );

    @POST("account.unban")
    Completable unban(
            @Query("owner_id") final int ownerId,
            @Query("access_token") @NonNull final String accessToken,
            @Query("v") @NonNull final String apiVersion
    );

    @GET("account.getBanned")
    Single<List<BannedAccount>> getBannedUsers(
            @Query("offset") @NonNull final String offset,
            @Query("count") @NonNull final String count,
            @Query("access_token") @NonNull final String accessToken,
            @Query("v") @NonNull final String apiVersion
    );

    @POST("account.setOffline")
    Completable setOffline(
            @Query("access_token") @NonNull final String accessToken,
            @Query("v") @NonNull final String apiVersion
    );

    @POST("account.setOnline")
    Completable setOnline(
            @Query("access_token") @NonNull final String accessToken,
            @Query("v") @NonNull final String apiVersion
    );

    @GET("account.getCounters")
    Single<Counters> getCounters(
            @Query("access_token") @NonNull final String accessToken,
            @Query("v") @NonNull final String apiVersion,
            @Query("filter") @NonNull final String... filter
    );

    @GET("account.getProfileInfo")
    Single<ProfileInfo> getProfileInfo(
      @Query("v") @NonNull final String apiVersion
    );

    @POST("account.registerDevice")
    Completable registerForPushNotifications(
            @Query("token") @NonNull final String token,
            @Query("device_model") @NonNull final String deviceModel,
            @Query("device_year") final int deviceYear,
            @Query("device_id") @NonNull final String deviceId,
            @Query("system_version") @NonNull final String systemVersion,
            @Query("version") @NonNull final String apiVersion
    );

    @POST("account.saveProfileInfo")
    Completable saveProfileInfo(
        @Body @NonNull final ProfileInfo profileInfo,
        @Query("access_token") @NonNull final String accessToken,
        @Query("v") @NonNull final String apiVersion
    );
}
