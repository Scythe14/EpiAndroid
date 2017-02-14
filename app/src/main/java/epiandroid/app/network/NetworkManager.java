package epiandroid.app.network;

import android.util.Log;
import com.fasterxml.jackson.databind.ObjectMapper;
import epiandroid.app.helpers.Helper;
import epiandroid.app.models.allmodules.AllModules;
import epiandroid.app.models.error.APIError;
import epiandroid.app.models.infos.History;
import epiandroid.app.models.infos.UserInfo;
import epiandroid.app.models.infos.board.Module;
import epiandroid.app.models.infos.board.Project;
import epiandroid.app.models.login.Token;
import epiandroid.app.models.mark.Mark;
import epiandroid.app.models.modules.Modules;
import epiandroid.app.models.photo.Photo;
import epiandroid.app.models.planning.Planning;
import epiandroid.app.models.projects.Projects;
import epiandroid.app.models.susie.Susie;
import epiandroid.app.models.susies.Susies;
import epiandroid.app.models.user.Trombi;
import epiandroid.app.models.user.User;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.*;

import java.util.List;

public class NetworkManager {
    static public NetworkManager    instance = new NetworkManager();
    private NetworkService          net_service;
    private String                   token = null;

    private NetworkManager() {
        buildNetworkService(Helper.config_file.getEndpoint());
    }

    private void buildNetworkService(final String endpoint) {
        net_service = new Retrofit.Builder()
                .baseUrl(endpoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NetworkService.class);
    }

    public NetworkService getNetworkService() { return net_service; }

    public void setToken(final Token t) { token = t.getToken(); }

    public String getToken() { return token; }

    public interface NetworkService {
        @FormUrlEncoded
        @POST("login")
        Call<Token>             login(@Field("login")String login, @Field("password")String password);

        @FormUrlEncoded
        @POST("infos")
        Call<UserInfo>          getUserInfos(@Field("token")String field);

        @GET("planning")
        Call<Planning[]>        getPlanning(@Query("token")String tok, @Query("start")String start,
                                            @Query("end")String end);

        @GET("susies")
        Call<List<Susies>>      getSusies(@Query("token")String tok, @Query("start")String start,
                                          @Query("end")String end, @Query("get")String get);

        @GET("susie")
        Call<Susie>             getSusie(@Query("token")String tok, @Query("id")String id,
                                         @Query("calendar_id")String calendar_id);

        @FormUrlEncoded
        @POST("/susie")
        Call<Susies>            registerSusie(@Field("token")String tok, @Field("id")String id,
                                               @Field("calendar_id")String calendar_id);

        @DELETE("/susie")
        Call<Susies>            deleteSusie(@Query("token")String tok, @Field("id")String id,
                                            @Query("calendar_id")String calendar_id);

        @GET("projects")
        Call<List<Projects>>    getProjects(@Query("token")String tok);

        @GET("project")
        Call<Project>           getProject(@Query("token")String tok,
                                           @Query("scolaryear")int scolaryear,
                                           @Query("codemodule")String codemodule,
                                           @Query("codeinstance")String codeinstance,
                                           @Query("codeacti")String codeacti);

        @FormUrlEncoded
        @POST("project")
        Call<APIError>              registerProject(@Field("token")String tok,
                                                @Field("scolaryear")int scolaryear,
                                                @Field("codemodule")String codemodule,
                                                @Field("codeinstance")String codeinstance,
                                                @Field("codeacti")String codeacti);

        @DELETE("project")
        Call<APIError>              deleteProject(@Query("token")String tok,
                                              @Query("scolaryear")int scolaryear,
                                              @Query("codemodule")String codemodule,
                                              @Query("codeinstance")String codeinstance,
                                              @Query("codeacti")String codeacti);

        @GET("project/files")
        Call<List<Planning>>    getProjectFiles(@Query("token")String tok,
                                                @Query("scolaryear")int scolaryear,
                                                @Query("codemodule")String codemodule,
                                                @Query("codeinstance")String codeinstance,
                                                @Query("codeacti")String codeacti);

        @GET("modules")
        Call<Modules>           getModules(@Query("token")String tok);

        @GET("allmodules")
        Call<AllModules>    getAllModules(@Query("token")String tok,
                                          @Query("scolaryear")int scolaryear,
                                          @Query("location")String location,
                                          @Query("course")String course);

        @GET("module")
        Call<List<Planning>>    getModule(@Query("token")String tok,
                                          @Query("scolaryear")int scolaryear,
                                          @Query("codemodule")String codemodule,
                                          @Query("codeinstance")String codeinstance);

        @FormUrlEncoded
        @POST("module")
        Call<APIError>              registerModule(@Field("token")String tok,
                                                   @Field("scolaryear")int scolaryear,
                                                   @Field("codemodule")String codemodule,
                                                   @Field("codeinstance")String codeinstance);

        @DELETE("module")
        Call<APIError>      deleteModule(@Query("token")String tok,
                                     @Query("scolaryear")int scolaryear,
                                     @Query("codemodule")String codemodule,
                                     @Query("codeinstance")String codeinstance);

        @GET("event")
        Call<List<Planning>>    getEvent(@Query("token")String tok,
                                         @Query("scolaryear")int scolaryear,
                                         @Query("codemodule")String codemodule,
                                         @Query("codeinstance")String codeinstance,
                                         @Query("codeacti")String codeacti,
                                         @Query("codeevent")String codeevent);

        @FormUrlEncoded
        @POST("event")
        Call<APIError>              registerEvent(@Field("token")String tok,
                                              @Field("scolaryear")int scolaryear,
                                              @Field("codemodule")String location,
                                              @Field("codeinstance")String codeinstance,
                                              @Field("codeacti")String codeacti,
                                              @Field("codeevent")String codeevent);

        @DELETE("event")
        Call<APIError>              deleteEvent(@Query("token")String tok,
                                            @Query("scolaryear")int scolaryear,
                                            @Query("codemodule")String location,
                                            @Query("codeinstance")String codeinstance,
                                            @Query("codeacti")String codeacti,
                                            @Query("codeevent")String codeevent);

        @GET("marks")
        Call<Mark>              getMarks(@Query("token")String tok);

        @GET("messages")
        Call<History[]>         getMessages(@Query("token")String tok);

        @GET("alerts")
        Call<List<Planning>>    getAlerts(@Query("token")String tok);

        @GET("photo")
        Call<Photo>             getPhoto(@Query("token")String tok, @Query("login")String login);

        @FormUrlEncoded
        @POST("token")
        Call<Token>             validateToken(@Field("token")String tok,
                                              @Field("scolaryear")int scolaryear,
                                              @Field("codemodule")String codemodule,
                                              @Field("codeinstance")String codeinstance,
                                              @Field("codeacti")String codeacti,
                                              @Field("codeevent")String codeevent,
                                              @Field("tokenvalidationcode")String tokenvalidationcode);

        @GET("trombi")
        Call<Trombi>    getStudents(@Query("token")String tok,
                                          @Query("year")int year,
                                          @Query("location")String location,
                                          @Query("course")String course,
                                          @Query("promo")String promo,
                                          @Query("offset")int offset);

        @GET("user")
        Call<User>              getInfo(@Query("token")String tok,
                                        @Query("user")String user);

    }

}
