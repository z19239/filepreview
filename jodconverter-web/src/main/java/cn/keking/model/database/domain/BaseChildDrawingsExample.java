package cn.keking.model.database.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseChildDrawingsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaseChildDrawingsExample() {
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

        public Criteria andVersionNoIsNull() {
            addCriterion("version_no is null");
            return (Criteria) this;
        }

        public Criteria andVersionNoIsNotNull() {
            addCriterion("version_no is not null");
            return (Criteria) this;
        }

        public Criteria andVersionNoEqualTo(String value) {
            addCriterion("version_no =", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoNotEqualTo(String value) {
            addCriterion("version_no <>", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoGreaterThan(String value) {
            addCriterion("version_no >", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoGreaterThanOrEqualTo(String value) {
            addCriterion("version_no >=", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoLessThan(String value) {
            addCriterion("version_no <", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoLessThanOrEqualTo(String value) {
            addCriterion("version_no <=", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoLike(String value) {
            addCriterion("version_no like", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoNotLike(String value) {
            addCriterion("version_no not like", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoIn(List<String> values) {
            addCriterion("version_no in", values, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoNotIn(List<String> values) {
            addCriterion("version_no not in", values, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoBetween(String value1, String value2) {
            addCriterion("version_no between", value1, value2, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoNotBetween(String value1, String value2) {
            addCriterion("version_no not between", value1, value2, "versionNo");
            return (Criteria) this;
        }

        public Criteria andCcinvcodeIsNull() {
            addCriterion("cCInvCode is null");
            return (Criteria) this;
        }

        public Criteria andCcinvcodeIsNotNull() {
            addCriterion("cCInvCode is not null");
            return (Criteria) this;
        }

        public Criteria andCcinvcodeEqualTo(String value) {
            addCriterion("cCInvCode =", value, "ccinvcode");
            return (Criteria) this;
        }

        public Criteria andCcinvcodeNotEqualTo(String value) {
            addCriterion("cCInvCode <>", value, "ccinvcode");
            return (Criteria) this;
        }

        public Criteria andCcinvcodeGreaterThan(String value) {
            addCriterion("cCInvCode >", value, "ccinvcode");
            return (Criteria) this;
        }

        public Criteria andCcinvcodeGreaterThanOrEqualTo(String value) {
            addCriterion("cCInvCode >=", value, "ccinvcode");
            return (Criteria) this;
        }

        public Criteria andCcinvcodeLessThan(String value) {
            addCriterion("cCInvCode <", value, "ccinvcode");
            return (Criteria) this;
        }

        public Criteria andCcinvcodeLessThanOrEqualTo(String value) {
            addCriterion("cCInvCode <=", value, "ccinvcode");
            return (Criteria) this;
        }

        public Criteria andCcinvcodeLike(String value) {
            addCriterion("cCInvCode like", value, "ccinvcode");
            return (Criteria) this;
        }

        public Criteria andCcinvcodeNotLike(String value) {
            addCriterion("cCInvCode not like", value, "ccinvcode");
            return (Criteria) this;
        }

        public Criteria andCcinvcodeIn(List<String> values) {
            addCriterion("cCInvCode in", values, "ccinvcode");
            return (Criteria) this;
        }

        public Criteria andCcinvcodeNotIn(List<String> values) {
            addCriterion("cCInvCode not in", values, "ccinvcode");
            return (Criteria) this;
        }

        public Criteria andCcinvcodeBetween(String value1, String value2) {
            addCriterion("cCInvCode between", value1, value2, "ccinvcode");
            return (Criteria) this;
        }

        public Criteria andCcinvcodeNotBetween(String value1, String value2) {
            addCriterion("cCInvCode not between", value1, value2, "ccinvcode");
            return (Criteria) this;
        }

        public Criteria andCversionNoIsNull() {
            addCriterion("cVersion_no is null");
            return (Criteria) this;
        }

        public Criteria andCversionNoIsNotNull() {
            addCriterion("cVersion_no is not null");
            return (Criteria) this;
        }

        public Criteria andCversionNoEqualTo(String value) {
            addCriterion("cVersion_no =", value, "cversionNo");
            return (Criteria) this;
        }

        public Criteria andCversionNoNotEqualTo(String value) {
            addCriterion("cVersion_no <>", value, "cversionNo");
            return (Criteria) this;
        }

        public Criteria andCversionNoGreaterThan(String value) {
            addCriterion("cVersion_no >", value, "cversionNo");
            return (Criteria) this;
        }

        public Criteria andCversionNoGreaterThanOrEqualTo(String value) {
            addCriterion("cVersion_no >=", value, "cversionNo");
            return (Criteria) this;
        }

        public Criteria andCversionNoLessThan(String value) {
            addCriterion("cVersion_no <", value, "cversionNo");
            return (Criteria) this;
        }

        public Criteria andCversionNoLessThanOrEqualTo(String value) {
            addCriterion("cVersion_no <=", value, "cversionNo");
            return (Criteria) this;
        }

        public Criteria andCversionNoLike(String value) {
            addCriterion("cVersion_no like", value, "cversionNo");
            return (Criteria) this;
        }

        public Criteria andCversionNoNotLike(String value) {
            addCriterion("cVersion_no not like", value, "cversionNo");
            return (Criteria) this;
        }

        public Criteria andCversionNoIn(List<String> values) {
            addCriterion("cVersion_no in", values, "cversionNo");
            return (Criteria) this;
        }

        public Criteria andCversionNoNotIn(List<String> values) {
            addCriterion("cVersion_no not in", values, "cversionNo");
            return (Criteria) this;
        }

        public Criteria andCversionNoBetween(String value1, String value2) {
            addCriterion("cVersion_no between", value1, value2, "cversionNo");
            return (Criteria) this;
        }

        public Criteria andCversionNoNotBetween(String value1, String value2) {
            addCriterion("cVersion_no not between", value1, value2, "cversionNo");
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