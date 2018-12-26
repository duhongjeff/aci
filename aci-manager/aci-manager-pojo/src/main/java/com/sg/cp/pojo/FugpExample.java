package com.sg.cp.pojo;

import java.util.ArrayList;
import java.util.List;

public class FugpExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table fugp
     *
     * @mbggenerated Sat Dec 22 10:59:11 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table fugp
     *
     * @mbggenerated Sat Dec 22 10:59:11 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table fugp
     *
     * @mbggenerated Sat Dec 22 10:59:11 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fugp
     *
     * @mbggenerated Sat Dec 22 10:59:11 CST 2018
     */
    public FugpExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fugp
     *
     * @mbggenerated Sat Dec 22 10:59:11 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fugp
     *
     * @mbggenerated Sat Dec 22 10:59:11 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fugp
     *
     * @mbggenerated Sat Dec 22 10:59:11 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fugp
     *
     * @mbggenerated Sat Dec 22 10:59:11 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fugp
     *
     * @mbggenerated Sat Dec 22 10:59:11 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fugp
     *
     * @mbggenerated Sat Dec 22 10:59:11 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fugp
     *
     * @mbggenerated Sat Dec 22 10:59:11 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fugp
     *
     * @mbggenerated Sat Dec 22 10:59:11 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fugp
     *
     * @mbggenerated Sat Dec 22 10:59:11 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fugp
     *
     * @mbggenerated Sat Dec 22 10:59:11 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table fugp
     *
     * @mbggenerated Sat Dec 22 10:59:11 CST 2018
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
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

        public Criteria andFuctiongpidIsNull() {
            addCriterion("fuctiongpid is null");
            return (Criteria) this;
        }

        public Criteria andFuctiongpidIsNotNull() {
            addCriterion("fuctiongpid is not null");
            return (Criteria) this;
        }

        public Criteria andFuctiongpidEqualTo(Integer value) {
            addCriterion("fuctiongpid =", value, "fuctiongpid");
            return (Criteria) this;
        }

        public Criteria andFuctiongpidNotEqualTo(Integer value) {
            addCriterion("fuctiongpid <>", value, "fuctiongpid");
            return (Criteria) this;
        }

        public Criteria andFuctiongpidGreaterThan(Integer value) {
            addCriterion("fuctiongpid >", value, "fuctiongpid");
            return (Criteria) this;
        }

        public Criteria andFuctiongpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fuctiongpid >=", value, "fuctiongpid");
            return (Criteria) this;
        }

        public Criteria andFuctiongpidLessThan(Integer value) {
            addCriterion("fuctiongpid <", value, "fuctiongpid");
            return (Criteria) this;
        }

        public Criteria andFuctiongpidLessThanOrEqualTo(Integer value) {
            addCriterion("fuctiongpid <=", value, "fuctiongpid");
            return (Criteria) this;
        }

        public Criteria andFuctiongpidIn(List<Integer> values) {
            addCriterion("fuctiongpid in", values, "fuctiongpid");
            return (Criteria) this;
        }

        public Criteria andFuctiongpidNotIn(List<Integer> values) {
            addCriterion("fuctiongpid not in", values, "fuctiongpid");
            return (Criteria) this;
        }

        public Criteria andFuctiongpidBetween(Integer value1, Integer value2) {
            addCriterion("fuctiongpid between", value1, value2, "fuctiongpid");
            return (Criteria) this;
        }

        public Criteria andFuctiongpidNotBetween(Integer value1, Integer value2) {
            addCriterion("fuctiongpid not between", value1, value2, "fuctiongpid");
            return (Criteria) this;
        }

        public Criteria andFunctiongpnameIsNull() {
            addCriterion("functiongpname is null");
            return (Criteria) this;
        }

        public Criteria andFunctiongpnameIsNotNull() {
            addCriterion("functiongpname is not null");
            return (Criteria) this;
        }

        public Criteria andFunctiongpnameEqualTo(String value) {
            addCriterion("functiongpname =", value, "functiongpname");
            return (Criteria) this;
        }

        public Criteria andFunctiongpnameNotEqualTo(String value) {
            addCriterion("functiongpname <>", value, "functiongpname");
            return (Criteria) this;
        }

        public Criteria andFunctiongpnameGreaterThan(String value) {
            addCriterion("functiongpname >", value, "functiongpname");
            return (Criteria) this;
        }

        public Criteria andFunctiongpnameGreaterThanOrEqualTo(String value) {
            addCriterion("functiongpname >=", value, "functiongpname");
            return (Criteria) this;
        }

        public Criteria andFunctiongpnameLessThan(String value) {
            addCriterion("functiongpname <", value, "functiongpname");
            return (Criteria) this;
        }

        public Criteria andFunctiongpnameLessThanOrEqualTo(String value) {
            addCriterion("functiongpname <=", value, "functiongpname");
            return (Criteria) this;
        }

        public Criteria andFunctiongpnameLike(String value) {
            addCriterion("functiongpname like", value, "functiongpname");
            return (Criteria) this;
        }

        public Criteria andFunctiongpnameNotLike(String value) {
            addCriterion("functiongpname not like", value, "functiongpname");
            return (Criteria) this;
        }

        public Criteria andFunctiongpnameIn(List<String> values) {
            addCriterion("functiongpname in", values, "functiongpname");
            return (Criteria) this;
        }

        public Criteria andFunctiongpnameNotIn(List<String> values) {
            addCriterion("functiongpname not in", values, "functiongpname");
            return (Criteria) this;
        }

        public Criteria andFunctiongpnameBetween(String value1, String value2) {
            addCriterion("functiongpname between", value1, value2, "functiongpname");
            return (Criteria) this;
        }

        public Criteria andFunctiongpnameNotBetween(String value1, String value2) {
            addCriterion("functiongpname not between", value1, value2, "functiongpname");
            return (Criteria) this;
        }

        public Criteria andActiveIsNull() {
            addCriterion("active is null");
            return (Criteria) this;
        }

        public Criteria andActiveIsNotNull() {
            addCriterion("active is not null");
            return (Criteria) this;
        }

        public Criteria andActiveEqualTo(Integer value) {
            addCriterion("active =", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotEqualTo(Integer value) {
            addCriterion("active <>", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThan(Integer value) {
            addCriterion("active >", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("active >=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThan(Integer value) {
            addCriterion("active <", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThanOrEqualTo(Integer value) {
            addCriterion("active <=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveIn(List<Integer> values) {
            addCriterion("active in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotIn(List<Integer> values) {
            addCriterion("active not in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveBetween(Integer value1, Integer value2) {
            addCriterion("active between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotBetween(Integer value1, Integer value2) {
            addCriterion("active not between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andReadonlyIsNull() {
            addCriterion("readonly is null");
            return (Criteria) this;
        }

        public Criteria andReadonlyIsNotNull() {
            addCriterion("readonly is not null");
            return (Criteria) this;
        }

        public Criteria andReadonlyEqualTo(Integer value) {
            addCriterion("readonly =", value, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyNotEqualTo(Integer value) {
            addCriterion("readonly <>", value, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyGreaterThan(Integer value) {
            addCriterion("readonly >", value, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyGreaterThanOrEqualTo(Integer value) {
            addCriterion("readonly >=", value, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyLessThan(Integer value) {
            addCriterion("readonly <", value, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyLessThanOrEqualTo(Integer value) {
            addCriterion("readonly <=", value, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyIn(List<Integer> values) {
            addCriterion("readonly in", values, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyNotIn(List<Integer> values) {
            addCriterion("readonly not in", values, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyBetween(Integer value1, Integer value2) {
            addCriterion("readonly between", value1, value2, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyNotBetween(Integer value1, Integer value2) {
            addCriterion("readonly not between", value1, value2, "readonly");
            return (Criteria) this;
        }

        public Criteria andCredateIsNull() {
            addCriterion("credate is null");
            return (Criteria) this;
        }

        public Criteria andCredateIsNotNull() {
            addCriterion("credate is not null");
            return (Criteria) this;
        }

        public Criteria andCredateEqualTo(Long value) {
            addCriterion("credate =", value, "credate");
            return (Criteria) this;
        }

        public Criteria andCredateNotEqualTo(Long value) {
            addCriterion("credate <>", value, "credate");
            return (Criteria) this;
        }

        public Criteria andCredateGreaterThan(Long value) {
            addCriterion("credate >", value, "credate");
            return (Criteria) this;
        }

        public Criteria andCredateGreaterThanOrEqualTo(Long value) {
            addCriterion("credate >=", value, "credate");
            return (Criteria) this;
        }

        public Criteria andCredateLessThan(Long value) {
            addCriterion("credate <", value, "credate");
            return (Criteria) this;
        }

        public Criteria andCredateLessThanOrEqualTo(Long value) {
            addCriterion("credate <=", value, "credate");
            return (Criteria) this;
        }

        public Criteria andCredateIn(List<Long> values) {
            addCriterion("credate in", values, "credate");
            return (Criteria) this;
        }

        public Criteria andCredateNotIn(List<Long> values) {
            addCriterion("credate not in", values, "credate");
            return (Criteria) this;
        }

        public Criteria andCredateBetween(Long value1, Long value2) {
            addCriterion("credate between", value1, value2, "credate");
            return (Criteria) this;
        }

        public Criteria andCredateNotBetween(Long value1, Long value2) {
            addCriterion("credate not between", value1, value2, "credate");
            return (Criteria) this;
        }

        public Criteria andLupdateIsNull() {
            addCriterion("lupdate is null");
            return (Criteria) this;
        }

        public Criteria andLupdateIsNotNull() {
            addCriterion("lupdate is not null");
            return (Criteria) this;
        }

        public Criteria andLupdateEqualTo(Long value) {
            addCriterion("lupdate =", value, "lupdate");
            return (Criteria) this;
        }

        public Criteria andLupdateNotEqualTo(Long value) {
            addCriterion("lupdate <>", value, "lupdate");
            return (Criteria) this;
        }

        public Criteria andLupdateGreaterThan(Long value) {
            addCriterion("lupdate >", value, "lupdate");
            return (Criteria) this;
        }

        public Criteria andLupdateGreaterThanOrEqualTo(Long value) {
            addCriterion("lupdate >=", value, "lupdate");
            return (Criteria) this;
        }

        public Criteria andLupdateLessThan(Long value) {
            addCriterion("lupdate <", value, "lupdate");
            return (Criteria) this;
        }

        public Criteria andLupdateLessThanOrEqualTo(Long value) {
            addCriterion("lupdate <=", value, "lupdate");
            return (Criteria) this;
        }

        public Criteria andLupdateIn(List<Long> values) {
            addCriterion("lupdate in", values, "lupdate");
            return (Criteria) this;
        }

        public Criteria andLupdateNotIn(List<Long> values) {
            addCriterion("lupdate not in", values, "lupdate");
            return (Criteria) this;
        }

        public Criteria andLupdateBetween(Long value1, Long value2) {
            addCriterion("lupdate between", value1, value2, "lupdate");
            return (Criteria) this;
        }

        public Criteria andLupdateNotBetween(Long value1, Long value2) {
            addCriterion("lupdate not between", value1, value2, "lupdate");
            return (Criteria) this;
        }

        public Criteria andDescIsNull() {
            addCriterion("desc is null");
            return (Criteria) this;
        }

        public Criteria andDescIsNotNull() {
            addCriterion("desc is not null");
            return (Criteria) this;
        }

        public Criteria andDescEqualTo(String value) {
            addCriterion("desc =", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotEqualTo(String value) {
            addCriterion("desc <>", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThan(String value) {
            addCriterion("desc >", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThanOrEqualTo(String value) {
            addCriterion("desc >=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThan(String value) {
            addCriterion("desc <", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThanOrEqualTo(String value) {
            addCriterion("desc <=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLike(String value) {
            addCriterion("desc like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotLike(String value) {
            addCriterion("desc not like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescIn(List<String> values) {
            addCriterion("desc in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotIn(List<String> values) {
            addCriterion("desc not in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescBetween(String value1, String value2) {
            addCriterion("desc between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotBetween(String value1, String value2) {
            addCriterion("desc not between", value1, value2, "desc");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table fugp
     *
     * @mbggenerated do_not_delete_during_merge Sat Dec 22 10:59:11 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table fugp
     *
     * @mbggenerated Sat Dec 22 10:59:11 CST 2018
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

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

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value) {
            super();
            this.condition = condition;
            this.value = value;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.betweenValue = true;
        }
    }
}