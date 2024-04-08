package com.patika.kredinbizdeservice.model;

import com.patika.kredinbizdeservice.enums.SectorType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "campaign")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campaignId;

    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "due_date")
    private LocalDate dueDate;
    @Column(name = "create_date")
    private LocalDate createDate;
    @Column(name = "update_date")
    private LocalDate updateDate;
    @Column(name = "sector")
    private SectorType sector;

}
