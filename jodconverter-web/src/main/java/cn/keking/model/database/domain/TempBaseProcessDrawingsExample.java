package cn.keking.model.database.domain;

import java.util.ArrayList;
import java.util.List;

public class TempBaseProcessDrawingsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TempBaseProcessDrawingsExample() {
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

        public Criteria andCinvcodeIsNull() {
            addCriterion("cInvCode is null");
            return (Criteria) this;
        }

        public Criteria andCinvcodeIsNotNull() {
            addCriterion("cInvCode is not null");
            return (Criteria) this;
        }

        public Criteria andCinvcodeEqualTo(String value) {
            addCriterion("cInvCode =", value, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeNotEqualTo(String value) {
            addCriterion("cInvCode <>", value, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeGreaterThan(String value) {
            addCriterion("cInvCode >", value, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeGreaterThanOrEqualTo(String value) {
            addCriterion("cInvCode >=", value, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeLessThan(String value) {
            addCriterion("cInvCode <", value, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeLessThanOrEqualTo(String value) {
            addCriterion("cInvCode <=", value, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeLike(String value) {
            addCriterion("cInvCode like", value, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeNotLike(String value) {
            addCriterion("cInvCode not like", value, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeIn(List<String> values) {
            addCriterion("cInvCode in", values, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeNotIn(List<String> values) {
            addCriterion("cInvCode not in", values, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeBetween(String value1, String value2) {
            addCriterion("cInvCode between", value1, value2, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeNotBetween(String value1, String value2) {
            addCriterion("cInvCode not between", value1, value2, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeIsNull() {
            addCriterion("cInvAddCode is null");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeIsNotNull() {
            addCriterion("cInvAddCode is not null");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeEqualTo(String value) {
            addCriterion("cInvAddCode =", value, "cinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeNotEqualTo(String value) {
            addCriterion("cInvAddCode <>", value, "cinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeGreaterThan(String value) {
            addCriterion("cInvAddCode >", value, "cinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeGreaterThanOrEqualTo(String value) {
            addCriterion("cInvAddCode >=", value, "cinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeLessThan(String value) {
            addCriterion("cInvAddCode <", value, "cinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeLessThanOrEqualTo(String value) {
            addCriterion("cInvAddCode <=", value, "cinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeLike(String value) {
            addCriterion("cInvAddCode like", value, "cinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeNotLike(String value) {
            addCriterion("cInvAddCode not like", value, "cinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeIn(List<String> values) {
            addCriterion("cInvAddCode in", values, "cinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeNotIn(List<String> values) {
            addCriterion("cInvAddCode not in", values, "cinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeBetween(String value1, String value2) {
            addCriterion("cInvAddCode between", value1, value2, "cinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeNotBetween(String value1, String value2) {
            addCriterion("cInvAddCode not between", value1, value2, "cinvaddcode");
            return (Criteria) this;
        }

        public Criteria andBcinvcodeIsNull() {
            addCriterion("bcInvCode is null");
            return (Criteria) this;
        }

        public Criteria andBcinvcodeIsNotNull() {
            addCriterion("bcInvCode is not null");
            return (Criteria) this;
        }

        public Criteria andBcinvcodeEqualTo(String value) {
            addCriterion("bcInvCode =", value, "bcinvcode");
            return (Criteria) this;
        }

        public Criteria andBcinvcodeNotEqualTo(String value) {
            addCriterion("bcInvCode <>", value, "bcinvcode");
            return (Criteria) this;
        }

        public Criteria andBcinvcodeGreaterThan(String value) {
            addCriterion("bcInvCode >", value, "bcinvcode");
            return (Criteria) this;
        }

        public Criteria andBcinvcodeGreaterThanOrEqualTo(String value) {
            addCriterion("bcInvCode >=", value, "bcinvcode");
            return (Criteria) this;
        }

        public Criteria andBcinvcodeLessThan(String value) {
            addCriterion("bcInvCode <", value, "bcinvcode");
            return (Criteria) this;
        }

        public Criteria andBcinvcodeLessThanOrEqualTo(String value) {
            addCriterion("bcInvCode <=", value, "bcinvcode");
            return (Criteria) this;
        }

        public Criteria andBcinvcodeLike(String value) {
            addCriterion("bcInvCode like", value, "bcinvcode");
            return (Criteria) this;
        }

        public Criteria andBcinvcodeNotLike(String value) {
            addCriterion("bcInvCode not like", value, "bcinvcode");
            return (Criteria) this;
        }

        public Criteria andBcinvcodeIn(List<String> values) {
            addCriterion("bcInvCode in", values, "bcinvcode");
            return (Criteria) this;
        }

        public Criteria andBcinvcodeNotIn(List<String> values) {
            addCriterion("bcInvCode not in", values, "bcinvcode");
            return (Criteria) this;
        }

        public Criteria andBcinvcodeBetween(String value1, String value2) {
            addCriterion("bcInvCode between", value1, value2, "bcinvcode");
            return (Criteria) this;
        }

        public Criteria andBcinvcodeNotBetween(String value1, String value2) {
            addCriterion("bcInvCode not between", value1, value2, "bcinvcode");
            return (Criteria) this;
        }

        public Criteria andFree1IsNull() {
            addCriterion("Free1 is null");
            return (Criteria) this;
        }

        public Criteria andFree1IsNotNull() {
            addCriterion("Free1 is not null");
            return (Criteria) this;
        }

        public Criteria andFree1EqualTo(String value) {
            addCriterion("Free1 =", value, "free1");
            return (Criteria) this;
        }

        public Criteria andFree1NotEqualTo(String value) {
            addCriterion("Free1 <>", value, "free1");
            return (Criteria) this;
        }

        public Criteria andFree1GreaterThan(String value) {
            addCriterion("Free1 >", value, "free1");
            return (Criteria) this;
        }

        public Criteria andFree1GreaterThanOrEqualTo(String value) {
            addCriterion("Free1 >=", value, "free1");
            return (Criteria) this;
        }

        public Criteria andFree1LessThan(String value) {
            addCriterion("Free1 <", value, "free1");
            return (Criteria) this;
        }

        public Criteria andFree1LessThanOrEqualTo(String value) {
            addCriterion("Free1 <=", value, "free1");
            return (Criteria) this;
        }

        public Criteria andFree1Like(String value) {
            addCriterion("Free1 like", value, "free1");
            return (Criteria) this;
        }

        public Criteria andFree1NotLike(String value) {
            addCriterion("Free1 not like", value, "free1");
            return (Criteria) this;
        }

        public Criteria andFree1In(List<String> values) {
            addCriterion("Free1 in", values, "free1");
            return (Criteria) this;
        }

        public Criteria andFree1NotIn(List<String> values) {
            addCriterion("Free1 not in", values, "free1");
            return (Criteria) this;
        }

        public Criteria andFree1Between(String value1, String value2) {
            addCriterion("Free1 between", value1, value2, "free1");
            return (Criteria) this;
        }

        public Criteria andFree1NotBetween(String value1, String value2) {
            addCriterion("Free1 not between", value1, value2, "free1");
            return (Criteria) this;
        }

        public Criteria andDraweNoIsNull() {
            addCriterion("drawe_no is null");
            return (Criteria) this;
        }

        public Criteria andDraweNoIsNotNull() {
            addCriterion("drawe_no is not null");
            return (Criteria) this;
        }

        public Criteria andDraweNoEqualTo(String value) {
            addCriterion("drawe_no =", value, "draweNo");
            return (Criteria) this;
        }

        public Criteria andDraweNoNotEqualTo(String value) {
            addCriterion("drawe_no <>", value, "draweNo");
            return (Criteria) this;
        }

        public Criteria andDraweNoGreaterThan(String value) {
            addCriterion("drawe_no >", value, "draweNo");
            return (Criteria) this;
        }

        public Criteria andDraweNoGreaterThanOrEqualTo(String value) {
            addCriterion("drawe_no >=", value, "draweNo");
            return (Criteria) this;
        }

        public Criteria andDraweNoLessThan(String value) {
            addCriterion("drawe_no <", value, "draweNo");
            return (Criteria) this;
        }

        public Criteria andDraweNoLessThanOrEqualTo(String value) {
            addCriterion("drawe_no <=", value, "draweNo");
            return (Criteria) this;
        }

        public Criteria andDraweNoLike(String value) {
            addCriterion("drawe_no like", value, "draweNo");
            return (Criteria) this;
        }

        public Criteria andDraweNoNotLike(String value) {
            addCriterion("drawe_no not like", value, "draweNo");
            return (Criteria) this;
        }

        public Criteria andDraweNoIn(List<String> values) {
            addCriterion("drawe_no in", values, "draweNo");
            return (Criteria) this;
        }

        public Criteria andDraweNoNotIn(List<String> values) {
            addCriterion("drawe_no not in", values, "draweNo");
            return (Criteria) this;
        }

        public Criteria andDraweNoBetween(String value1, String value2) {
            addCriterion("drawe_no between", value1, value2, "draweNo");
            return (Criteria) this;
        }

        public Criteria andDraweNoNotBetween(String value1, String value2) {
            addCriterion("drawe_no not between", value1, value2, "draweNo");
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