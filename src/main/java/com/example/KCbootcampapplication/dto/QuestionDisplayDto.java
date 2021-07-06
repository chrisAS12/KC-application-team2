package com.example.KCbootcampapplication.dto;

import com.example.KCbootcampapplication.domain.Question;

import java.util.ArrayList;
import java.util.List;


public class QuestionDisplayDto {
    public List<Question> questionList;
    public List<Boolean> multipleAnswers;

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public void addQuestion(Question question) {
        this.questionList.add(question);
    }

    public List<Boolean> getMultipleAnswers() {
        return multipleAnswers;
    }

    public void setMultipleAnswers(List<Boolean> multipleAnswers) {
        this.multipleAnswers = multipleAnswers;
    }

    public Question getQuestion(int index) {
        return questionList.get(index);
    }

    public QuestionDisplayDto(int questionListSize, int multipleAnswerSize) {
        questionList = new ArrayList<>(questionListSize);
        multipleAnswers = new ArrayList<Boolean>(multipleAnswerSize);
    }

    public QuestionDisplayDto() {
        questionList = new ArrayList<>();
        multipleAnswers = new ArrayList<Boolean>();
    }

}
