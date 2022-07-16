package com.manish0890.spring.sample.persistance.document;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

import static org.springframework.data.elasticsearch.annotations.DateFormat.epoch_millis;

public abstract class BaseDocument {

    @Id
    protected String id;

    @Field(type = FieldType.Date, format = epoch_millis)
    protected Date createdDate;

    @Field(type = FieldType.Date, format = epoch_millis)
    protected Date updatedDate;

    @Override
    public boolean equals(Object o) {
        String[] excludedFields = {"id", "createdDate", "updatedDate"};
        return o instanceof BaseDocument && (
                this == o || EqualsBuilder.reflectionEquals(this, o, excludedFields));
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, true);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
