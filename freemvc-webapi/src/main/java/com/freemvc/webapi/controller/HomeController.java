package com.freemvc.webapi.controller;

import com.freemvc.datacontract.request.GetUserListRequest;
import com.freemvc.datacontract.response.BaseResponse;
import com.freemvc.datacontract.response.GetUserListResponse;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yangliangbin on 2016/9/22.
 * Swagger不支持泛型啊……
 * 处理方法：把freemvc-datacontract层的BaseResponse泛型去掉，所有响应类继承BaseResponse即可
 * 打开htpp://localhost:8080/index.html即可看到生成的文档
 */
@RestController
@RequestMapping("/api/home")
public class HomeController extends  BaseController {
    @RequestMapping("/test")
    @ApiOperation(value = "获取用户列表", httpMethod = "GET", response = BaseResponse.class, notes = "根据指定条件获取用户列表")
    public BaseResponse<List<GetUserListResponse>> GetUserList(GetUserListRequest request) {
        BaseResponse<List<GetUserListResponse>> response;
        response = getUserService().getUserList(request);
        return response;
    }
}
