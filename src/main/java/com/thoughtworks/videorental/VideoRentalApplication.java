package com.thoughtworks.videorental;


import com.thoughtworks.videorental.resources.VideoRentalResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

public class VideoRentalApplication extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new VideoRentalApplication().run(args);
    }


    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle());
        bootstrap.addBundle(new ViewBundle());
    }

    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment) {



        environment.jersey().register(new VideoRentalResource());
    }
}
