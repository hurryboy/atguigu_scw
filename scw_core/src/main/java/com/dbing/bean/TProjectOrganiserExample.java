package com.dbing.bean;

import java.util.ArrayList;
import java.util.List;

public class TProjectOrganiserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TProjectOrganiserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andDescsIsNull() {
            addCriterion("descs is null");
            return (Criteria) this;
        }

        public Criteria andDescsIsNotNull() {
            addCriterion("descs is not null");
            return (Criteria) this;
        }

        public Criteria andDescsEqualTo(String value) {
            addCriterion("descs =", value, "descs");
            return (Criteria) this;
        }

        public Criteria andDescsNotEqualTo(String value) {
            addCriterion("descs <>", value, "descs");
            return (Criteria) this;
        }

        public Criteria andDescsGreaterThan(String value) {
            addCriterion("descs >", value, "descs");
            return (Criteria) this;
        }

        public Criteria andDescsGreaterThanOrEqualTo(String value) {
            addCriterion("descs >=", value, "descs");
            return (Criteria) this;
        }

        public Criteria andDescsLessThan(String value) {
            addCriterion("descs <", value, "descs");
            return (Criteria) this;
        }

        public Criteria andDescsLessThanOrEqualTo(String value) {
            addCriterion("descs <=", value, "descs");
            return (Criteria) this;
        }

        public Criteria andDescsLike(String value) {
            addCriterion("descs like", value, "descs");
            return (Criteria) this;
        }

        public Criteria andDescsNotLike(String value) {
            addCriterion("descs not like", value, "descs");
            return (Criteria) this;
        }

        public Criteria andDescsIn(List<String> values) {
            addCriterion("descs in", values, "descs");
            return (Criteria) this;
        }

        public Criteria andDescsNotIn(List<String> values) {
            addCriterion("descs not in", values, "descs");
            return (Criteria) this;
        }

        public Criteria andDescsBetween(String value1, String value2) {
            addCriterion("descs between", value1, value2, "descs");
            return (Criteria) this;
        }

        public Criteria andDescsNotBetween(String value1, String value2) {
            addCriterion("descs not between", value1, value2, "descs");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(Integer value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(Integer value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(Integer value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(Integer value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(Integer value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<Integer> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<Integer> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(Integer value1, Integer value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(Integer value1, Integer value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andServicephoneIsNull() {
            addCriterion("servicephone is null");
            return (Criteria) this;
        }

        public Criteria andServicephoneIsNotNull() {
            addCriterion("servicephone is not null");
            return (Criteria) this;
        }

        public Criteria andServicephoneEqualTo(Integer value) {
            addCriterion("servicephone =", value, "servicephone");
            return (Criteria) this;
        }

        public Criteria andServicephoneNotEqualTo(Integer value) {
            addCriterion("servicephone <>", value, "servicephone");
            return (Criteria) this;
        }

        public Criteria andServicephoneGreaterThan(Integer value) {
            addCriterion("servicephone >", value, "servicephone");
            return (Criteria) this;
        }

        public Criteria andServicephoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("servicephone >=", value, "servicephone");
            return (Criteria) this;
        }

        public Criteria andServicephoneLessThan(Integer value) {
            addCriterion("servicephone <", value, "servicephone");
            return (Criteria) this;
        }

        public Criteria andServicephoneLessThanOrEqualTo(Integer value) {
            addCriterion("servicephone <=", value, "servicephone");
            return (Criteria) this;
        }

        public Criteria andServicephoneIn(List<Integer> values) {
            addCriterion("servicephone in", values, "servicephone");
            return (Criteria) this;
        }

        public Criteria andServicephoneNotIn(List<Integer> values) {
            addCriterion("servicephone not in", values, "servicephone");
            return (Criteria) this;
        }

        public Criteria andServicephoneBetween(Integer value1, Integer value2) {
            addCriterion("servicephone between", value1, value2, "servicephone");
            return (Criteria) this;
        }

        public Criteria andServicephoneNotBetween(Integer value1, Integer value2) {
            addCriterion("servicephone not between", value1, value2, "servicephone");
            return (Criteria) this;
        }

        public Criteria andPaycardIsNull() {
            addCriterion("paycard is null");
            return (Criteria) this;
        }

        public Criteria andPaycardIsNotNull() {
            addCriterion("paycard is not null");
            return (Criteria) this;
        }

        public Criteria andPaycardEqualTo(Integer value) {
            addCriterion("paycard =", value, "paycard");
            return (Criteria) this;
        }

        public Criteria andPaycardNotEqualTo(Integer value) {
            addCriterion("paycard <>", value, "paycard");
            return (Criteria) this;
        }

        public Criteria andPaycardGreaterThan(Integer value) {
            addCriterion("paycard >", value, "paycard");
            return (Criteria) this;
        }

        public Criteria andPaycardGreaterThanOrEqualTo(Integer value) {
            addCriterion("paycard >=", value, "paycard");
            return (Criteria) this;
        }

        public Criteria andPaycardLessThan(Integer value) {
            addCriterion("paycard <", value, "paycard");
            return (Criteria) this;
        }

        public Criteria andPaycardLessThanOrEqualTo(Integer value) {
            addCriterion("paycard <=", value, "paycard");
            return (Criteria) this;
        }

        public Criteria andPaycardIn(List<Integer> values) {
            addCriterion("paycard in", values, "paycard");
            return (Criteria) this;
        }

        public Criteria andPaycardNotIn(List<Integer> values) {
            addCriterion("paycard not in", values, "paycard");
            return (Criteria) this;
        }

        public Criteria andPaycardBetween(Integer value1, Integer value2) {
            addCriterion("paycard between", value1, value2, "paycard");
            return (Criteria) this;
        }

        public Criteria andPaycardNotBetween(Integer value1, Integer value2) {
            addCriterion("paycard not between", value1, value2, "paycard");
            return (Criteria) this;
        }

        public Criteria andLegalcardIsNull() {
            addCriterion("legalCard is null");
            return (Criteria) this;
        }

        public Criteria andLegalcardIsNotNull() {
            addCriterion("legalCard is not null");
            return (Criteria) this;
        }

        public Criteria andLegalcardEqualTo(Integer value) {
            addCriterion("legalCard =", value, "legalcard");
            return (Criteria) this;
        }

        public Criteria andLegalcardNotEqualTo(Integer value) {
            addCriterion("legalCard <>", value, "legalcard");
            return (Criteria) this;
        }

        public Criteria andLegalcardGreaterThan(Integer value) {
            addCriterion("legalCard >", value, "legalcard");
            return (Criteria) this;
        }

        public Criteria andLegalcardGreaterThanOrEqualTo(Integer value) {
            addCriterion("legalCard >=", value, "legalcard");
            return (Criteria) this;
        }

        public Criteria andLegalcardLessThan(Integer value) {
            addCriterion("legalCard <", value, "legalcard");
            return (Criteria) this;
        }

        public Criteria andLegalcardLessThanOrEqualTo(Integer value) {
            addCriterion("legalCard <=", value, "legalcard");
            return (Criteria) this;
        }

        public Criteria andLegalcardIn(List<Integer> values) {
            addCriterion("legalCard in", values, "legalcard");
            return (Criteria) this;
        }

        public Criteria andLegalcardNotIn(List<Integer> values) {
            addCriterion("legalCard not in", values, "legalcard");
            return (Criteria) this;
        }

        public Criteria andLegalcardBetween(Integer value1, Integer value2) {
            addCriterion("legalCard between", value1, value2, "legalcard");
            return (Criteria) this;
        }

        public Criteria andLegalcardNotBetween(Integer value1, Integer value2) {
            addCriterion("legalCard not between", value1, value2, "legalcard");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}