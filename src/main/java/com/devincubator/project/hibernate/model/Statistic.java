package com.devincubator.project.hibernate.model;

import com.devincubator.project.hibernate.model.abstracts.EntityAbstract;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.DETACH;

@Entity
public class Statistic extends EntityAbstract {

    private static final long serialVersionUID = -6372957177860305322L;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private boolean correct;
    private Integer userId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {MERGE, PERSIST, REFRESH, DETACH})
    @JoinColumn(name = "questionId", nullable = false,insertable=false, updatable=false)
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {MERGE, PERSIST, REFRESH, DETACH})
    @JoinColumn(name = "userId", nullable = false,insertable=false, updatable=false)
    private User user;
    private Integer questionId;

    public Statistic() {
    }

    public Statistic(Date date, boolean correct, Question question, User user) {
        this.date = date;
        this.correct = correct;
        this.question = question;
        this.user = user;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistic statistic = (Statistic) o;
        return correct == statistic.correct &&
                Objects.equals(date, statistic.date) &&
                Objects.equals(question.getId(), statistic.question.getId()) &&
                Objects.equals(user.getId(), statistic.user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, correct, question.getId(), user.getId());
    }

    @Override
    public String toString() {
        return "Statistic{" +
                super.toString() +
                ", date=" + date +
                ", correct=" + correct +
                ", questionId=" + question.getId() +
                ", userId=" + user.getId() +
                '}';
    }
}
