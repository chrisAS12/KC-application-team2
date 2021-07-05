package com.example.KCbootcampapplication.dto;

import com.example.KCbootcampapplication.domain.Question;

import java.util.ArrayList;
import java.util.List;


public class QuestionDisplayDto {
    public List<Question> questionList;
    public String answer = "";

    public void addQuestion(Question question) {
        this.questionList.add(question);
    }

    public Question getQuestion(int index){
        return questionList.get(index);
    }

    public List<Question> getAllQuestions(){
        return questionList;
    }

    public  QuestionDisplayDto(int size){
        questionList = new ArrayList<>(size);
    }
}
