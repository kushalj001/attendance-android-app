package io.github.djunicode.attendanceapp;

import java.util.ArrayList;

import io.github.djunicode.attendanceapp.CommonModels.StudentDetailsModel;
import io.github.djunicode.attendanceapp.StudentSide.WebLecturesAttended;
import io.github.djunicode.attendanceapp.TeacherSide.Models.WebLectureOfDay;
import io.github.djunicode.attendanceapp.TeacherSide.Models.WebLectureOfDayDetails;
import io.github.djunicode.attendanceapp.TeacherSide.Models.WebSendAttendance;
import io.github.djunicode.attendanceapp.TeacherSide.Models.WebStudents;
import io.github.djunicode.attendanceapp.TeacherSide.TokenRequest;
import io.github.djunicode.attendanceapp.TeacherSide.TokenResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitInterface {
    @GET("get-lectures-of-the-day/{date}")
    Call<WebLectureOfDay> teacherTimeTable(@Header("Authorization")String header, @Path("date")String date);

    @GET("get-student-list/{subject}/{batch}")
    Call<WebStudents> studentList(@Header("Authorization")String header,@Path("subject")String subject,@Path("batch")String batch);

    @GET("get-students-attendance/")
    Call<WebLecturesAttended> studentLectures(@Header("Authorization")String header);

    @POST("generic-login/")
    Call<TokenResponse> login(@Body TokenRequest tokenRequest);

    @POST("save-attendance/")
    Call<WebSendAttendance>sendAttendance(@Body WebSendAttendance webSendAttendance);
}
