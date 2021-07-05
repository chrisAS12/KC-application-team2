package com.example.KCbootcampapplication.dto;

import com.example.KCbootcampapplication.domain.Question;

import java.util.ArrayList;
import java.util.List;


public class QuestionDisplayDto {
    public List<Question> questionList;
    public String answer = "";

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public void addQuestion(Question question) {
        this.questionList.add(question);
    }

    public Question getQuestion(int index){
        return questionList.get(index);
    }

    public  QuestionDisplayDto(int size){
        questionList = new ArrayList<>(size);
    }
    public QuestionDisplayDto() {questionList = new ArrayList<>();}
}
