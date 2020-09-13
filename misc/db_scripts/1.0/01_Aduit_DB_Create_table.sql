--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2020-05-28 20:56:26

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 26052)
-- Name: amq_error_log; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.amq_error_log (
    amq_error_log_id bigint NOT NULL,
    amq_message character varying(255),
    created_date timestamp without time zone,
    error_message character varying(255),
    organization_id bigint,
    publisher_service_id integer,
    subscriber_service_id integer,
    user_id bigint
);


ALTER TABLE public.amq_error_log OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 26050)
-- Name: amq_error_log_amq_error_log_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.amq_error_log_amq_error_log_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.amq_error_log_amq_error_log_id_seq OWNER TO postgres;

--
-- TOC entry 3023 (class 0 OID 0)
-- Dependencies: 202
-- Name: amq_error_log_amq_error_log_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.amq_error_log_amq_error_log_id_seq OWNED BY public.amq_error_log.amq_error_log_id;


--
-- TOC entry 205 (class 1259 OID 26063)
-- Name: application_log; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.application_log (
    application_log_id integer NOT NULL,
    log_date timestamp without time zone,
    log_level character varying(10) NOT NULL,
    logger character varying(250) NOT NULL,
    message character varying(255),
    throwable character varying(255),
    service_id integer NOT NULL
);


ALTER TABLE public.application_log OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 26061)
-- Name: application_log_application_log_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.application_log_application_log_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.application_log_application_log_id_seq OWNER TO postgres;

--
-- TOC entry 3024 (class 0 OID 0)
-- Dependencies: 204
-- Name: application_log_application_log_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.application_log_application_log_id_seq OWNED BY public.application_log.application_log_id;


--
-- TOC entry 207 (class 1259 OID 26074)
-- Name: audit_level; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.audit_level (
    audit_level_id integer NOT NULL,
    audit_level_desc character varying(255),
    audit_level_name character varying(50) NOT NULL
);


ALTER TABLE public.audit_level OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 26072)
-- Name: audit_level_audit_level_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.audit_level_audit_level_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.audit_level_audit_level_id_seq OWNER TO postgres;

--
-- TOC entry 3025 (class 0 OID 0)
-- Dependencies: 206
-- Name: audit_level_audit_level_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.audit_level_audit_level_id_seq OWNED BY public.audit_level.audit_level_id;


--
-- TOC entry 209 (class 1259 OID 26082)
-- Name: entity_additional_info; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.entity_additional_info (
    entity_additional_info_id integer NOT NULL,
    created_by bigint,
    created_date timestamp without time zone,
    entity_name character varying(255),
    entity_reference_id bigint,
    param_name character varying(255),
    param_value character varying(255)
);


ALTER TABLE public.entity_additional_info OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 26080)
-- Name: entity_additional_info_entity_additional_info_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.entity_additional_info_entity_additional_info_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.entity_additional_info_entity_additional_info_id_seq OWNER TO postgres;

--
-- TOC entry 3026 (class 0 OID 0)
-- Dependencies: 208
-- Name: entity_additional_info_entity_additional_info_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.entity_additional_info_entity_additional_info_id_seq OWNED BY public.entity_additional_info.entity_additional_info_id;


--
-- TOC entry 211 (class 1259 OID 26093)
-- Name: ip_audit_log; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ip_audit_log (
    ip_audit_log_id bigint NOT NULL,
    client_city character varying(255),
    client_country_code character varying(255),
    client_ip_address character varying(255),
    client_ip_lookup_response character varying(255),
    client_latitude character varying(255),
    client_longitude character varying(255),
    client_state character varying(255),
    client_zip_code character varying(255),
    created_by bigint,
    created_date timestamp without time zone
);


ALTER TABLE public.ip_audit_log OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 26091)
-- Name: ip_audit_log_ip_audit_log_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ip_audit_log_ip_audit_log_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ip_audit_log_ip_audit_log_id_seq OWNER TO postgres;

--
-- TOC entry 3027 (class 0 OID 0)
-- Dependencies: 210
-- Name: ip_audit_log_ip_audit_log_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ip_audit_log_ip_audit_log_id_seq OWNED BY public.ip_audit_log.ip_audit_log_id;


--
-- TOC entry 213 (class 1259 OID 26104)
-- Name: language; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.language (
    language_id integer NOT NULL,
    created_by bigint,
    created_date timestamp without time zone,
    is_active boolean,
    updated_by bigint,
    updated_date timestamp without time zone,
    description character varying(100),
    language_code character varying(20) NOT NULL
);


ALTER TABLE public.language OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 26102)
-- Name: language_language_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.language_language_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.language_language_id_seq OWNER TO postgres;

--
-- TOC entry 3028 (class 0 OID 0)
-- Dependencies: 212
-- Name: language_language_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.language_language_id_seq OWNED BY public.language.language_id;


--
-- TOC entry 219 (class 1259 OID 26131)
-- Name: service; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.service (
    service_id integer NOT NULL,
    service_desc character varying(255),
    service_name character varying(50) NOT NULL
);


ALTER TABLE public.service OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 26139)
-- Name: service_category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.service_category (
    service_category_id integer NOT NULL,
    created_by bigint,
    created_date timestamp without time zone,
    is_active boolean,
    updated_by bigint,
    updated_date timestamp without time zone,
    service_category_external_name character varying(150) NOT NULL,
    service_category_internal_name character varying(150) NOT NULL
);


ALTER TABLE public.service_category OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 26137)
-- Name: service_category_service_category_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.service_category_service_category_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.service_category_service_category_id_seq OWNER TO postgres;

--
-- TOC entry 3031 (class 0 OID 0)
-- Dependencies: 220
-- Name: service_category_service_category_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.service_category_service_category_id_seq OWNED BY public.service_category.service_category_id;


--
-- TOC entry 223 (class 1259 OID 26147)
-- Name: service_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.service_entity (
    service_entity_id integer NOT NULL,
    created_by bigint,
    created_date timestamp without time zone,
    is_active boolean,
    updated_by bigint,
    updated_date timestamp without time zone,
    entity character varying(255),
    entity_primary_key character varying(255),
    service_id integer NOT NULL
);


ALTER TABLE public.service_entity OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 26145)
-- Name: service_entity_service_entity_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.service_entity_service_entity_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.service_entity_service_entity_id_seq OWNER TO postgres;

--
-- TOC entry 3032 (class 0 OID 0)
-- Dependencies: 222
-- Name: service_entity_service_entity_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.service_entity_service_entity_id_seq OWNED BY public.service_entity.service_entity_id;


--
-- TOC entry 218 (class 1259 OID 26129)
-- Name: service_service_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.service_service_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.service_service_id_seq OWNER TO postgres;

--
-- TOC entry 3033 (class 0 OID 0)
-- Dependencies: 218
-- Name: service_service_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.service_service_id_seq OWNED BY public.service.service_id;



--
-- TOC entry 227 (class 1259 OID 26166)
-- Name: user_event; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_event (
    user_event_id bigint NOT NULL,
    application integer,
    created_date timestamp without time zone,
    enterprise_domain character varying(255),
    enterprise_ip_address character varying(255),
    enterprise_url character varying(255),
    sca_service_request text,
    sca_service_response text,
    sca_service_url character varying(255),
    organization_id bigint,
    reference_id bigint,
    service_request_status integer,
    updated_date timestamp without time zone,
    user_event_description character varying(255),
    user_event_name character varying(255),
    user_event_page_title character varying(255),
    user_event_source_url character varying(255),
    user_id bigint,
    ip_audit_log_id bigint,
    service_category_id integer,
    service_entity_id integer,
    user_event_type_id integer,
    kukun_service_request character varying(255),
    kukun_service_response character varying(255),
    kukun_service_url character varying(255)
);


ALTER TABLE public.user_event OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 26177)
-- Name: user_event_param; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_event_param (
    user_event_param_id bigint NOT NULL,
    user_event_id bigint,
    user_event_param_name character varying(255),
    user_event_param_value character varying(255)
);


ALTER TABLE public.user_event_param OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 26175)
-- Name: user_event_param_user_event_param_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_event_param_user_event_param_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_event_param_user_event_param_id_seq OWNER TO postgres;

--
-- TOC entry 3035 (class 0 OID 0)
-- Dependencies: 228
-- Name: user_event_param_user_event_param_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_event_param_user_event_param_id_seq OWNED BY public.user_event_param.user_event_param_id;


--
-- TOC entry 231 (class 1259 OID 26188)
-- Name: user_event_type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_event_type (
    user_event_type_id integer NOT NULL,
    created_by bigint,
    created_date timestamp without time zone,
    is_active boolean,
    updated_by bigint,
    updated_date timestamp without time zone,
    user_event_type_external_name character varying(255),
    user_event_type_internal_name character varying(255)
);


ALTER TABLE public.user_event_type OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 26186)
-- Name: user_event_type_user_event_type_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_event_type_user_event_type_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_event_type_user_event_type_id_seq OWNER TO postgres;

--
-- TOC entry 3036 (class 0 OID 0)
-- Dependencies: 230
-- Name: user_event_type_user_event_type_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_event_type_user_event_type_id_seq OWNED BY public.user_event_type.user_event_type_id;


--
-- TOC entry 226 (class 1259 OID 26164)
-- Name: user_event_user_event_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_event_user_event_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_event_user_event_id_seq OWNER TO postgres;

--
-- TOC entry 3037 (class 0 OID 0)
-- Dependencies: 226
-- Name: user_event_user_event_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_event_user_event_id_seq OWNED BY public.user_event.user_event_id;




--
-- TOC entry 2793 (class 2604 OID 26055)
-- Name: amq_error_log amq_error_log_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.amq_error_log ALTER COLUMN amq_error_log_id SET DEFAULT nextval('public.amq_error_log_amq_error_log_id_seq'::regclass);


--
-- TOC entry 2794 (class 2604 OID 26066)
-- Name: application_log application_log_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.application_log ALTER COLUMN application_log_id SET DEFAULT nextval('public.application_log_application_log_id_seq'::regclass);


--
-- TOC entry 2795 (class 2604 OID 26077)
-- Name: audit_level audit_level_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.audit_level ALTER COLUMN audit_level_id SET DEFAULT nextval('public.audit_level_audit_level_id_seq'::regclass);


--
-- TOC entry 2796 (class 2604 OID 26085)
-- Name: entity_additional_info entity_additional_info_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.entity_additional_info ALTER COLUMN entity_additional_info_id SET DEFAULT nextval('public.entity_additional_info_entity_additional_info_id_seq'::regclass);


--
-- TOC entry 2797 (class 2604 OID 26096)
-- Name: ip_audit_log ip_audit_log_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ip_audit_log ALTER COLUMN ip_audit_log_id SET DEFAULT nextval('public.ip_audit_log_ip_audit_log_id_seq'::regclass);


--
-- TOC entry 2798 (class 2604 OID 26107)
-- Name: language language_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.language ALTER COLUMN language_id SET DEFAULT nextval('public.language_language_id_seq'::regclass);



--
-- TOC entry 2801 (class 2604 OID 26134)
-- Name: service service_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.service ALTER COLUMN service_id SET DEFAULT nextval('public.service_service_id_seq'::regclass);


--
-- TOC entry 2802 (class 2604 OID 26142)
-- Name: service_category service_category_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.service_category ALTER COLUMN service_category_id SET DEFAULT nextval('public.service_category_service_category_id_seq'::regclass);


--
-- TOC entry 2803 (class 2604 OID 26150)
-- Name: service_entity service_entity_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.service_entity ALTER COLUMN service_entity_id SET DEFAULT nextval('public.service_entity_service_entity_id_seq'::regclass);


--
-- TOC entry 2804 (class 2604 OID 26161)
-- Name: state_name state_name_id; Type: DEFAULT; Schema: public; Owner: postgres
--

--ALTER TABLE ONLY public.state_name ALTER COLUMN state_name_id SET DEFAULT nextval('public.state_name_state_name_id_seq'::regclass);


--
-- TOC entry 2805 (class 2604 OID 26169)
-- Name: user_event user_event_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_event ALTER COLUMN user_event_id SET DEFAULT nextval('public.user_event_user_event_id_seq'::regclass);


--
-- TOC entry 2806 (class 2604 OID 26180)
-- Name: user_event_param user_event_param_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_event_param ALTER COLUMN user_event_param_id SET DEFAULT nextval('public.user_event_param_user_event_param_id_seq'::regclass);


--
-- TOC entry 2807 (class 2604 OID 26191)
-- Name: user_event_type user_event_type_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_event_type ALTER COLUMN user_event_type_id SET DEFAULT nextval('public.user_event_type_user_event_type_id_seq'::regclass);