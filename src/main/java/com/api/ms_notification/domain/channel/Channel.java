package com.api.ms_notification.domain.channel;

import jakarta.persistence.*;

@Entity(name = "channels")
@Table(name = "tb_channels")
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long channelId;
    private String description;

    public Channel() {

    }

    public Channel(Long channelId, String description) {
        this.channelId = channelId;
        this.description = description;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Values {

        EMAIL(1L, "email"),
        WHATSAPP(2L, "whatsApp"),
        PUSH(3L, "push"),
        SMS(4L, "sms");

        private Long id;
        private String description;

        Values(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        public Channel toChannel() {

            return new Channel(id, description);
        }
    }

}
