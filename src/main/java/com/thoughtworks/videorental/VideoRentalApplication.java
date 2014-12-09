package com.thoughtworks.videorental;

import com.sun.jersey.api.client.ViewResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;




public class VideoRentalApplication {

    public static void main(String[] args) throws Exception {
        new VideoRentalApplication().run(args);
    }


    @Override
    public String getName() {
        return "Video-rental";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        bootstrap.addCommand(new RenderCommand());
        bootstrap.addBundle(new AssetsBundle());
//        bootstrap.addBundle(new MigrationsBundle<HelloWorldConfiguration>() {
//            @Override
//            public DataSourceFactory getDataSourceFactory(HelloWorldConfiguration configuration) {
//                return configuration.getDataSourceFactory();
//            }
//        });
////        bootstrap.addBundle(hibernateBundle);
//        bootstrap.addBundle(new ViewBundle());
    }

    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment) {

       // environment.healthChecks().register("template", new TemplateHealthCheck(template));
        //environment.jersey().register(DateRequiredFeature.class);

//        environment.jersey().register(AuthFactory.binder(new BasicAuthFactory<>(new ExampleAuthenticator(),"SUPER SECRET STUFF", User.class)));
//        environment.jersey().register(new HelloWorldResource(template));
        environment.jersey().register(new ViewResource());
//        environment.jersey().register(new ProtectedResource());
//        environment.jersey().register(new PeopleResource(dao));
//        environment.jersey().register(new PersonResource(dao));
//        environment.jersey().register(new FilteredResource());
//
    }

}
