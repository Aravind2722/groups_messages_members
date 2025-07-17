package org.example.groups_messages_members.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Member {
    @Id
    private Long id;

    private String name;
    @ManyToMany
    @JoinTable(
            name = "MEMBERS_WHATSAPP_GROUPS",
            joinColumns = @JoinColumn(name = "MEMBER_ID"),
            inverseJoinColumns = @JoinColumn(name = "WHATSAPP_GROUP_ID")
    )
    private Set<WhatsappGroup> groups=new HashSet<>();

    @OneToMany(mappedBy = "author")
    private List<Message> messages=new ArrayList<>();
}
