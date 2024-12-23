package com.example.spring_final.Models;

import java.util.Date;



import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.Date;
    //NO NEED TO CREATE TABLE IT'S JUST MAP FOR PRODUCT AND CATEGORY
    @MappedSuperclass
    public class BaseModel {

        /* these are common variable present in both product and category
         ID WILL ACTS LIKE PK FOR BOTH CATEGORY AND PRODUCT
         ID IN TABLE AUTO GENERATED
        ID ACTS LIKE UNIQUELY IDENTIFIER -->UNIQUELY IDENTIFY ANY ROW IN THAT TABLE*/
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private Date createdAt;
        private Date lastModified;
        private boolean isDeleted;


        public BaseModel(long id, Date createdAt, Date lastModified, boolean isDeleted) {
            this.id = id;
            this.createdAt = createdAt;
            this.lastModified = lastModified;
            this.isDeleted = isDeleted;
        }

        public BaseModel() {
        }

        public long getId() {
            return this.id;
        }

        public Date getCreatedAt() {
            return this.createdAt;
        }

        public Date getLastModified() {
            return this.lastModified;
        }

        public boolean isDeleted() {
            return this.isDeleted;
        }

        public void setId(long id) {
            this.id = id;
        }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }

        public void setLastModified(Date lastModified) {
            this.lastModified = lastModified;
        }

        public void setDeleted(boolean isDeleted) {
            this.isDeleted = isDeleted;
        }
    }


