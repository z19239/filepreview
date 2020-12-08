package cn.keking.model.database.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseProcessDrawingsDetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaseProcessDrawingsDetailsExample() {
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

        public Criteria andPdIdIsNull() {
            addCriterion("pd_id is null");
            return (Criteria) this;
        }

        public Criteria andPdIdIsNotNull() {
            addCriterion("pd_id is not null");
            return (Criteria) this;
        }

        public Criteria andPdIdEqualTo(Integer value) {
            addCriterion("pd_id =", value, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdNotEqualTo(Integer value) {
            addCriterion("pd_id <>", value, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdGreaterThan(Integer value) {
            addCriterion("pd_id >", value, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pd_id >=", value, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdLessThan(Integer value) {
            addCriterion("pd_id <", value, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdLessThanOrEqualTo(Integer value) {
            addCriterion("pd_id <=", value, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdIn(List<Integer> values) {
            addCriterion("pd_id in", values, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdNotIn(List<Integer> values) {
            addCriterion("pd_id not in", values, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdBetween(Integer value1, Integer value2) {
            addCriterion("pd_id between", value1, value2, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pd_id not between", value1, value2, "pdId");
            return (Criteria) this;
        }

        public Criteria andDrawingTypeIsNull() {
            addCriterion("drawing_type is null");
            return (Criteria) this;
        }

        public Criteria andDrawingTypeIsNotNull() {
            addCriterion("drawing_type is not null");
            return (Criteria) this;
        }

        public Criteria andDrawingTypeEqualTo(Integer value) {
            addCriterion("drawing_type =", value, "drawingType");
            return (Criteria) this;
        }

        public Criteria andDrawingTypeNotEqualTo(Integer value) {
            addCriterion("drawing_type <>", value, "drawingType");
            return (Criteria) this;
        }

        public Criteria andDrawingTypeGreaterThan(Integer value) {
            addCriterion("drawing_type >", value, "drawingType");
            return (Criteria) this;
        }

        public Criteria andDrawingTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("drawing_type >=", value, "drawingType");
            return (Criteria) this;
        }

        public Criteria andDrawingTypeLessThan(Integer value) {
            addCriterion("drawing_type <", value, "drawingType");
            return (Criteria) this;
        }

        public Criteria andDrawingTypeLessThanOrEqualTo(Integer value) {
            addCriterion("drawing_type <=", value, "drawingType");
            return (Criteria) this;
        }

        public Criteria andDrawingTypeIn(List<Integer> values) {
            addCriterion("drawing_type in", values, "drawingType");
            return (Criteria) this;
        }

        public Criteria andDrawingTypeNotIn(List<Integer> values) {
            addCriterion("drawing_type not in", values, "drawingType");
            return (Criteria) this;
        }

        public Criteria andDrawingTypeBetween(Integer value1, Integer value2) {
            addCriterion("drawing_type between", value1, value2, "drawingType");
            return (Criteria) this;
        }

        public Criteria andDrawingTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("drawing_type not between", value1, value2, "drawingType");
            return (Criteria) this;
        }

        public Criteria andDrawingPathIsNull() {
            addCriterion("drawing_path is null");
            return (Criteria) this;
        }

        public Criteria andDrawingPathIsNotNull() {
            addCriterion("drawing_path is not null");
            return (Criteria) this;
        }

        public Criteria andDrawingPathEqualTo(String value) {
            addCriterion("drawing_path =", value, "drawingPath");
            return (Criteria) this;
        }

        public Criteria andDrawingPathNotEqualTo(String value) {
            addCriterion("drawing_path <>", value, "drawingPath");
            return (Criteria) this;
        }

        public Criteria andDrawingPathGreaterThan(String value) {
            addCriterion("drawing_path >", value, "drawingPath");
            return (Criteria) this;
        }

        public Criteria andDrawingPathGreaterThanOrEqualTo(String value) {
            addCriterion("drawing_path >=", value, "drawingPath");
            return (Criteria) this;
        }

        public Criteria andDrawingPathLessThan(String value) {
            addCriterion("drawing_path <", value, "drawingPath");
            return (Criteria) this;
        }

        public Criteria andDrawingPathLessThanOrEqualTo(String value) {
            addCriterion("drawing_path <=", value, "drawingPath");
            return (Criteria) this;
        }

        public Criteria andDrawingPathLike(String value) {
            addCriterion("drawing_path like", value, "drawingPath");
            return (Criteria) this;
        }

        public Criteria andDrawingPathNotLike(String value) {
            addCriterion("drawing_path not like", value, "drawingPath");
            return (Criteria) this;
        }

        public Criteria andDrawingPathIn(List<String> values) {
            addCriterion("drawing_path in", values, "drawingPath");
            return (Criteria) this;
        }

        public Criteria andDrawingPathNotIn(List<String> values) {
            addCriterion("drawing_path not in", values, "drawingPath");
            return (Criteria) this;
        }

        public Criteria andDrawingPathBetween(String value1, String value2) {
            addCriterion("drawing_path between", value1, value2, "drawingPath");
            return (Criteria) this;
        }

        public Criteria andDrawingPathNotBetween(String value1, String value2) {
            addCriterion("drawing_path not between", value1, value2, "drawingPath");
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