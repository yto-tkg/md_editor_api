package com.md.editor.markdown;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = Markdown.TABLE_NAME)
@Getter
@Setter
public class Markdown {

    public static final String TABLE_NAME = "markdown";

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String body;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAte;
}
