package com.mystudy.firstproject.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@ToString
@Getter @Setter
public class user_role {

    @Id
    private String userId;
    @Id
    private String roleId;
}
