package com.woodpecker.backend.dtos;

import com.woodpecker.backend.model.Category;
import com.woodpecker.backend.model.Difficulty;
import com.woodpecker.backend.model.FlashCard;
import com.woodpecker.backend.model.User;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

public class FlashcardResponse
{
    private String id;
    private String question;
    private String answer;
    private String category;
    private Difficulty difficulty;
    private LocalDate timeSkip;
    private int numberReview;

    private String categoryId;

    public FlashcardResponse(){}

    public FlashcardResponse(FlashCard x) {
        id = x.getId();
        question = x.getQuestion();
        answer = x.getAnswer();
        category = x.getCategory();
        difficulty = x.getDifficulty();
        timeSkip = x.getTimeSkip();
        numberReview = x.getNumberReview();
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public LocalDate getTimeSkip() {
        return timeSkip;
    }

    public void setTimeSkip(LocalDate timeSkip) {
        this.timeSkip = timeSkip;
    }

    public int getNumberReview() {
        return numberReview;
    }

    public void setNumberReview(int numberReview) {
        this.numberReview = numberReview;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
