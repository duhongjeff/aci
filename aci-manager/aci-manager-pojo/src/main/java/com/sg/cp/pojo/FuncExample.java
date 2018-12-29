package com.sg.cp.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FuncExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table func
     *
     * @mbggenerated Sat Dec 29 16:19:32 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table func
     *
     * @mbggenerated Sat Dec 29 16:19:32 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table func
     *
     * @mbggenerated Sat Dec 29 16:19:32 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table func
     *
     * @mbggenerated Sat Dec 29 16:19:32 CST 2018
     */
    public FuncExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table func
     *
     * @mbggenerated Sat Dec 29 16:19:32 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table func
     *
     * @mbggenerated Sat Dec 29 16:19:32 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table func
     *
     * @mbggenerated Sat Dec 29 16:19:32 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table func
     *
     * @mbggenerated Sat Dec 29 16:19:32 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table func
     *
     * @mbggenerated Sat Dec 29 16:19:32 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table func
     *
     * @mbggenerated Sat Dec 29 16:19:32 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table func
     *
     * @mbggenerated Sat Dec 29 16:19:32 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table func
     *
     * @mbggenerated Sat Dec 29 16:19:32 CST 2018
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
     * This method corresponds to the database table func
     *
     * @mbggenerated Sat Dec 29 16:19:32 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table func
     *
     * @mbggenerated Sat Dec 29 16:19:32 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table func
     *
     * @mbggenerated Sat Dec 29 16:19:32 CST 2018
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

        public Criteria andFunctionidIsNull() {
            addCriterion("functionid is null");
            return (Criteria) this;
        }

        public Criteria andFunctionidIsNotNull() {
            addCriterion("functionid is not null");
            return (Criteria) this;
        }

        public Criteria andFunctionidEqualTo(Integer value) {
            addCriterion("functionid =", value, "functionid");
            return (Criteria) this;
        }

        public Criteria andFunctionidNotEqualTo(Integer value) {
            addCriterion("functionid <>", value, "functionid");
            return (Criteria) this;
        }

        public Criteria andFunctionidGreaterThan(Integer value) {
            addCriterion("functionid >", value, "functionid");
            return (Criteria) this;
        }

        public Criteria andFunctionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("functionid >=", value, "functionid");
            return (Criteria) this;
        }

        public Criteria andFunctionidLessThan(Integer value) {
            addCriterion("functionid <", value, "functionid");
            return (Criteria) this;
        }

        public Criteria andFunctionidLessThanOrEqualTo(Integer value) {
            addCriterion("functionid <=", value, "functionid");
            return (Criteria) this;
        }

        public Criteria andFunctionidIn(List<Integer> values) {
            addCriterion("functionid in", values, "functionid");
            return (Criteria) this;
        }

        public Criteria andFunctionidNotIn(List<Integer> values) {
            addCriterion("functionid not in", values, "functionid");
            return (Criteria) this;
        }

        public Criteria andFunctionidBetween(Integer value1, Integer value2) {
            addCriterion("functionid between", value1, value2, "functionid");
            return (Criteria) this;
        }

        public Criteria andFunctionidNotBetween(Integer value1, Integer value2) {
            addCriterion("functionid not between", value1, value2, "functionid");
            return (Criteria) this;
        }

        public Criteria andFunctionnameIsNull() {
            addCriterion("functionname is null");
            return (Criteria) this;
        }

        public Criteria andFunctionnameIsNotNull() {
            addCriterion("functionname is not null");
            return (Criteria) this;
        }

        public Criteria andFunctionnameEqualTo(String value) {
            addCriterion("functionname =", value, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameNotEqualTo(String value) {
            addCriterion("functionname <>", value, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameGreaterThan(String value) {
            addCriterion("functionname >", value, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameGreaterThanOrEqualTo(String value) {
            addCriterion("functionname >=", value, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameLessThan(String value) {
            addCriterion("functionname <", value, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameLessThanOrEqualTo(String value) {
            addCriterion("functionname <=", value, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameLike(String value) {
            addCriterion("functionname like", value, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameNotLike(String value) {
            addCriterion("functionname not like", value, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameIn(List<String> values) {
            addCriterion("functionname in", values, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameNotIn(List<String> values) {
            addCriterion("functionname not in", values, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameBetween(String value1, String value2) {
            addCriterion("functionname between", value1, value2, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameNotBetween(String value1, String value2) {
            addCriterion("functionname not between", value1, value2, "functionname");
            return (Criteria) this;
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andCredateEqualTo(Date value) {
            addCriterion("credate =", value, "credate");
            return (Criteria) this;
        }

        public Criteria andCredateNotEqualTo(Date value) {
            addCriterion("credate <>", value, "credate");
            return (Criteria) this;
        }

        public Criteria andCredateGreaterThan(Date value) {
            addCriterion("credate >", value, "credate");
            return (Criteria) this;
        }

        public Criteria andCredateGreaterThanOrEqualTo(Date value) {
            addCriterion("credate >=", value, "credate");
            return (Criteria) this;
        }

        public Criteria andCredateLessThan(Date value) {
            addCriterion("credate <", value, "credate");
            return (Criteria) this;
        }

        public Criteria andCredateLessThanOrEqualTo(Date value) {
            addCriterion("credate <=", value, "credate");
            return (Criteria) this;
        }

        public Criteria andCredateIn(List<Date> values) {
            addCriterion("credate in", values, "credate");
            return (Criteria) this;
        }

        public Criteria andCredateNotIn(List<Date> values) {
            addCriterion("credate not in", values, "credate");
            return (Criteria) this;
        }

        public Criteria andCredateBetween(Date value1, Date value2) {
            addCriterion("credate between", value1, value2, "credate");
            return (Criteria) this;
        }

        public Criteria andCredateNotBetween(Date value1, Date value2) {
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

        public Criteria andLupdateEqualTo(Date value) {
            addCriterion("lupdate =", value, "lupdate");
            return (Criteria) this;
        }

        public Criteria andLupdateNotEqualTo(Date value) {
            addCriterion("lupdate <>", value, "lupdate");
            return (Criteria) this;
        }

        public Criteria andLupdateGreaterThan(Date value) {
            addCriterion("lupdate >", value, "lupdate");
            return (Criteria) this;
        }

        public Criteria andLupdateGreaterThanOrEqualTo(Date value) {
            addCriterion("lupdate >=", value, "lupdate");
            return (Criteria) this;
        }

        public Criteria andLupdateLessThan(Date value) {
            addCriterion("lupdate <", value, "lupdate");
            return (Criteria) this;
        }

        public Criteria andLupdateLessThanOrEqualTo(Date value) {
            addCriterion("lupdate <=", value, "lupdate");
            return (Criteria) this;
        }

        public Criteria andLupdateIn(List<Date> values) {
            addCriterion("lupdate in", values, "lupdate");
            return (Criteria) this;
        }

        public Criteria andLupdateNotIn(List<Date> values) {
            addCriterion("lupdate not in", values, "lupdate");
            return (Criteria) this;
        }

        public Criteria andLupdateBetween(Date value1, Date value2) {
            addCriterion("lupdate between", value1, value2, "lupdate");
            return (Criteria) this;
        }

        public Criteria andLupdateNotBetween(Date value1, Date value2) {
            addCriterion("lupdate not between", value1, value2, "lupdate");
            return (Criteria) this;
        }

        public Criteria andCrebyIsNull() {
            addCriterion("creby is null");
            return (Criteria) this;
        }

        public Criteria andCrebyIsNotNull() {
            addCriterion("creby is not null");
            return (Criteria) this;
        }

        public Criteria andCrebyEqualTo(String value) {
            addCriterion("creby =", value, "creby");
            return (Criteria) this;
        }

        public Criteria andCrebyNotEqualTo(String value) {
            addCriterion("creby <>", value, "creby");
            return (Criteria) this;
        }

        public Criteria andCrebyGreaterThan(String value) {
            addCriterion("creby >", value, "creby");
            return (Criteria) this;
        }

        public Criteria andCrebyGreaterThanOrEqualTo(String value) {
            addCriterion("creby >=", value, "creby");
            return (Criteria) this;
        }

        public Criteria andCrebyLessThan(String value) {
            addCriterion("creby <", value, "creby");
            return (Criteria) this;
        }

        public Criteria andCrebyLessThanOrEqualTo(String value) {
            addCriterion("creby <=", value, "creby");
            return (Criteria) this;
        }

        public Criteria andCrebyLike(String value) {
            addCriterion("creby like", value, "creby");
            return (Criteria) this;
        }

        public Criteria andCrebyNotLike(String value) {
            addCriterion("creby not like", value, "creby");
            return (Criteria) this;
        }

        public Criteria andCrebyIn(List<String> values) {
            addCriterion("creby in", values, "creby");
            return (Criteria) this;
        }

        public Criteria andCrebyNotIn(List<String> values) {
            addCriterion("creby not in", values, "creby");
            return (Criteria) this;
        }

        public Criteria andCrebyBetween(String value1, String value2) {
            addCriterion("creby between", value1, value2, "creby");
            return (Criteria) this;
        }

        public Criteria andCrebyNotBetween(String value1, String value2) {
            addCriterion("creby not between", value1, value2, "creby");
            return (Criteria) this;
        }

        public Criteria andLupbyIsNull() {
            addCriterion("lupby is null");
            return (Criteria) this;
        }

        public Criteria andLupbyIsNotNull() {
            addCriterion("lupby is not null");
            return (Criteria) this;
        }

        public Criteria andLupbyEqualTo(String value) {
            addCriterion("lupby =", value, "lupby");
            return (Criteria) this;
        }

        public Criteria andLupbyNotEqualTo(String value) {
            addCriterion("lupby <>", value, "lupby");
            return (Criteria) this;
        }

        public Criteria andLupbyGreaterThan(String value) {
            addCriterion("lupby >", value, "lupby");
            return (Criteria) this;
        }

        public Criteria andLupbyGreaterThanOrEqualTo(String value) {
            addCriterion("lupby >=", value, "lupby");
            return (Criteria) this;
        }

        public Criteria andLupbyLessThan(String value) {
            addCriterion("lupby <", value, "lupby");
            return (Criteria) this;
        }

        public Criteria andLupbyLessThanOrEqualTo(String value) {
            addCriterion("lupby <=", value, "lupby");
            return (Criteria) this;
        }

        public Criteria andLupbyLike(String value) {
            addCriterion("lupby like", value, "lupby");
            return (Criteria) this;
        }

        public Criteria andLupbyNotLike(String value) {
            addCriterion("lupby not like", value, "lupby");
            return (Criteria) this;
        }

        public Criteria andLupbyIn(List<String> values) {
            addCriterion("lupby in", values, "lupby");
            return (Criteria) this;
        }

        public Criteria andLupbyNotIn(List<String> values) {
            addCriterion("lupby not in", values, "lupby");
            return (Criteria) this;
        }

        public Criteria andLupbyBetween(String value1, String value2) {
            addCriterion("lupby between", value1, value2, "lupby");
            return (Criteria) this;
        }

        public Criteria andLupbyNotBetween(String value1, String value2) {
            addCriterion("lupby not between", value1, value2, "lupby");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table func
     *
     * @mbggenerated do_not_delete_during_merge Sat Dec 29 16:19:32 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table func
     *
     * @mbggenerated Sat Dec 29 16:19:32 CST 2018
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