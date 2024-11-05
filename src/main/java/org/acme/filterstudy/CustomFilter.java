package org.acme.filterstudy;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.core.Response;
import java.io.IOException;

@Provider
public class CustomFilter implements ContainerRequestFilter, ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // リクエストフィルタ: Authorizationヘッダーがなければ401を返す
        System.out.println("Request filter: " + requestContext.getUriInfo().getPath());
        System.out.println("Request filter: " + requestContext.getMethod());
        
        System.out.println("Request filter: " + requestContext.getUriInfo());
        String authHeader = requestContext.getHeaderString("Authorization");
        if (authHeader == null || authHeader.isEmpty()) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity("{\"error\":\"Authorization header is missing\"}")
                    .build());
        }

        var test = requestContext.getUriInfo().getPath().split("/");
        System.out.println(test);
        for (var t : test){
            System.out.println(t);
        }

        System.out.println("path" + requestContext.getUriInfo().getPath().split("/")[1]);

        if (requestContext.getUriInfo().getPath().split("/")[0].equals("/api")){
            System.out.println("YES");
        }

        
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        System.out.println("Response filter: " + responseContext.getStatus());
        // レスポンスフィルタ: 共通ヘッダーを追加
        responseContext.getHeaders().add("X-Processed-By", "CustomFilter");
    }
}