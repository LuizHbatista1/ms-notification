package com.api.ms_notification.infra;

import com.api.ms_notification.domain.channel.Channel;
import com.api.ms_notification.domain.status.Status;
import com.api.ms_notification.repositories.ChannelRepository;
import com.api.ms_notification.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {


    private final StatusRepository statusRepository;
    private final ChannelRepository channelRepository;

    @Autowired
    public DataLoader(StatusRepository statusRepository, ChannelRepository channelRepository) {
        this.statusRepository = statusRepository;
        this.channelRepository = channelRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Arrays.stream(Channel.Values.values())
                .map(Channel.Values::toChannel)
                .forEach(channelRepository::save);

        Arrays.stream(Status.Values.values())
                .map(Status.Values::toStatus)
                .forEach(statusRepository::save);

    }
}
