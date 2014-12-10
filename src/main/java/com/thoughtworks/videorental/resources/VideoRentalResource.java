package com.thoughtworks.videorental.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import io.dropwizard.jersey.caching.CacheControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class VideoRentalResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(VideoRentalResource.class);

    private final AtomicLong counter;

    public VideoRentalResource() {
        this.counter = new AtomicLong();
    }

    @GET
    @Timed(name = "get-requests")
    @CacheControl(maxAge = 1, maxAgeUnit = TimeUnit.DAYS)
    public String sayHello(@QueryParam("name") Optional<String> name) {
        return "" + counter.incrementAndGet() + name.or("world");
    }

    @POST
    public void receiveHello(@Valid String saying) {
        LOGGER.info("Received a saying: {}", saying);
    }
}
