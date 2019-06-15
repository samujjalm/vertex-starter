package dev.samujjal.weekend.vertxdemo;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class VertXConsoleRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Vertx vertx = Vertx.vertx();
        HttpServer httpServer = vertx.createHttpServer();
        Router router = Router.router(vertx);
        Route route = router.route("/hello");
        route.handler(routingContext -> {
            HttpServerResponse httpServerResponse = routingContext.response();
            httpServerResponse.putHeader("SAMUJJAL", "MAJUMDER");
            httpServerResponse.end("First Response");
        });

        Route chunckedRoute = router.route("/chunked");
        chunckedRoute.handler(routingContext -> {

        });

        httpServer.requestHandler(router).listen(8080);
    }

    //Booking platform: kevin charaka
//    vishal evan for search, Andy backend infra
}
