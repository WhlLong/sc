package com.whl.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈Zuul过滤器〉
 *
 * @author whl
 * @create 2019/4/4
 * @since 1.0.0
 */
public class WhlFilter extends ZuulFilter {

    /**
     * 过滤器类型，决定过滤器在请求的哪个周期执行
     * pre: 路由之前
     * route:
     * post:
     * error:
     *
     * @return
     */
    @Override
    public String filterType() {
        return "post";
    }

    /**
     * 过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行。
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否需要被执行。
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }


    /**
     * 过滤器的具体逻辑。这里我们通过requestContext.setSendZuulResponse(false)令zuul过滤该请求，
     * 不对其进行路由，然后通过requestContext.setResponseStatusCode(401)设置了其返回的错误码，
     * 当然我们也可以进一步优化我们的返回，比如，通过requestContext.setResponseBody(body)对返回body内容进行编辑等
     *
     * @return
     */
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        System.out.println("send {" + request.getMethod() + "} request to {" + request.getRequestURL().toString() + "}");

        String token = request.getParameter("token");

        if(token == null || "".equals(token)){
            System.out.println("token is empty");
            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("没有权限");
            return null;
        }
        System.out.println("token is "+token);
        return null;
    }
}