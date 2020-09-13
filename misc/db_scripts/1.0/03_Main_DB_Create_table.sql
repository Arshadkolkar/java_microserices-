--
-- PostgreSQL database dump
--

-- Dumped from database version 11.7
-- Dumped by pg_dump version 11.7

-- Started on 2020-08-18 14:09:56

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

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 62522)
-- Name: address_type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.address_type (
    address_type_id bigint NOT NULL,
    description character varying(255),
    name character varying(255)
);


ALTER TABLE public.address_type OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 62530)
-- Name: country; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.country (
    country_id integer NOT NULL,
    display_name character varying(255),
    name character varying(255)
);


ALTER TABLE public.country OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 62540)
-- Name: credit_card; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.credit_card (
    credit_card_id bigint NOT NULL,
    created_by bigint,
    created_date timestamp without time zone,
    entity_status_id integer,
    is_active boolean,
    updated_by bigint,
    updated_date timestamp without time zone,
    credit_card_expiry_date character varying(255),
    credit_card_holder_name character varying(255),
    credit_card_number bigint,
    credit_card_security_code integer,
    is_default boolean,
    credit_card_type_id integer,
    sca_user_id bigint
);


ALTER TABLE public.credit_card OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 62538)
-- Name: credit_card_credit_card_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.credit_card_credit_card_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.credit_card_credit_card_id_seq OWNER TO postgres;

--
-- TOC entry 3013 (class 0 OID 0)
-- Dependencies: 198
-- Name: credit_card_credit_card_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.credit_card_credit_card_id_seq OWNED BY public.credit_card.credit_card_id;


--
-- TOC entry 200 (class 1259 OID 62549)
-- Name: credit_card_type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.credit_card_type (
    credit_card_type_id integer NOT NULL,
    display_name character varying(255),
    name character varying(255)
);


ALTER TABLE public.credit_card_type OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 62559)
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
-- TOC entry 201 (class 1259 OID 62557)
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
-- TOC entry 3014 (class 0 OID 0)
-- Dependencies: 201
-- Name: entity_additional_info_entity_additional_info_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.entity_additional_info_entity_additional_info_id_seq OWNED BY public.entity_additional_info.entity_additional_info_id;


--
-- TOC entry 203 (class 1259 OID 62568)
-- Name: entity_status; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.entity_status (
    entity_status_id integer NOT NULL,
    description integer,
    name character varying(255)
);


ALTER TABLE public.entity_status OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 62575)
-- Name: job; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job (
    job_id bigint NOT NULL,
    created_by bigint,
    created_date timestamp without time zone,
    entity_status_id integer,
    is_active boolean,
    updated_by bigint,
    updated_date timestamp without time zone,
    job_class character varying(255),
    job_description character varying(255),
    job_group character varying(255),
    job_name character varying(255)
);


ALTER TABLE public.job OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 62573)
-- Name: job_job_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.job_job_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.job_job_id_seq OWNER TO postgres;

--
-- TOC entry 3015 (class 0 OID 0)
-- Dependencies: 204
-- Name: job_job_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.job_job_id_seq OWNED BY public.job.job_id;


--
-- TOC entry 207 (class 1259 OID 62586)
-- Name: job_trigger; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job_trigger (
    trigger_id bigint NOT NULL,
    created_by bigint,
    created_date timestamp without time zone,
    entity_status_id integer,
    is_active boolean,
    updated_by bigint,
    updated_date timestamp without time zone,
    day_number_of_month character varying(255),
    end_24hour integer,
    end_date timestamp without time zone,
    end_minute integer,
    friday_enabled boolean,
    job_id bigint,
    monday_enabled boolean,
    repeat_every character varying(255),
    repeat_interval integer,
    saturday_enabled boolean,
    start_24hour integer,
    start_date timestamp without time zone,
    start_minute integer,
    sunday_enabled boolean,
    thursday_enabled boolean,
    tuesday_enabled boolean,
    wednesday_enabled boolean
);


ALTER TABLE public.job_trigger OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 62584)
-- Name: job_trigger_trigger_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.job_trigger_trigger_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.job_trigger_trigger_id_seq OWNER TO postgres;

--
-- TOC entry 3016 (class 0 OID 0)
-- Dependencies: 206
-- Name: job_trigger_trigger_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.job_trigger_trigger_id_seq OWNED BY public.job_trigger.trigger_id;


--
-- TOC entry 208 (class 1259 OID 62595)
-- Name: language; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.language (
    language_id integer NOT NULL,
    created_by bigint,
    created_date timestamp without time zone,
    entity_status_id integer,
    is_active boolean,
    updated_by bigint,
    updated_date timestamp without time zone,
    description character varying(100),
    language_code character varying(20) NOT NULL
);


ALTER TABLE public.language OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 62602)
-- Name: order_notification; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.order_notification (
    order_notification_id integer NOT NULL,
    created_by bigint,
    created_date timestamp without time zone,
    entity_status_id integer,
    is_active boolean,
    updated_by bigint,
    updated_date timestamp without time zone,
    email character varying(255),
    first_name character varying(255),
    is_24_hour boolean,
    is_billing_related boolean,
    is_dnd_disturb boolean,
    is_engineer boolean,
    is_pcb_designer boolean,
    is_primary boolean,
    is_quality_control_related boolean,
    is_share_project boolean,
    is_shipping_related boolean,
    last_name character varying(255),
    order_id bigint,
    phone_number character varying(255),
    sca_user_id bigint,
    user_id bigint,
    wmq_id character varying(255)
);


ALTER TABLE public.order_notification OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 62600)
-- Name: order_notification_order_notification_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.order_notification_order_notification_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.order_notification_order_notification_id_seq OWNER TO postgres;

--
-- TOC entry 3017 (class 0 OID 0)
-- Dependencies: 209
-- Name: order_notification_order_notification_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.order_notification_order_notification_id_seq OWNED BY public.order_notification.order_notification_id;


--
-- TOC entry 211 (class 1259 OID 62611)
-- Name: project_properties; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project_properties (
    project_id uuid NOT NULL,
    assembly_part_number character varying(255),
    board_name character varying(255),
    company_name character varying(255),
    description character varying(255),
    project_name character varying(255),
    quantity_individual_boards integer NOT NULL,
    revision character varying(255)
);


ALTER TABLE public.project_properties OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 62617)
-- Name: projects; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.projects (
    project_id uuid NOT NULL,
    status boolean,
    user_id character varying(255)
);


ALTER TABLE public.projects OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 62624)
-- Name: quote_cache_data; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.quote_cache_data (
    quote_cache_data_id bigint NOT NULL,
    design_file character varying(255),
    electrical_testing_cost character varying(255),
    quote_request_json text,
    quote_response_price_matrix_json text,
    wmq_id character varying(255)
);


ALTER TABLE public.quote_cache_data OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 62622)
-- Name: quote_cache_data_quote_cache_data_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.quote_cache_data_quote_cache_data_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.quote_cache_data_quote_cache_data_id_seq OWNER TO postgres;

--
-- TOC entry 3018 (class 0 OID 0)
-- Dependencies: 213
-- Name: quote_cache_data_quote_cache_data_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.quote_cache_data_quote_cache_data_id_seq OWNED BY public.quote_cache_data.quote_cache_data_id;


--
-- TOC entry 216 (class 1259 OID 62635)
-- Name: sca_address; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sca_address (
    address_id bigint NOT NULL,
    created_by bigint,
    created_date timestamp without time zone,
    entity_status_id integer,
    is_active boolean,
    updated_by bigint,
    updated_date timestamp without time zone,
    address_line1 character varying(255),
    address_line2 character varying(255),
    city character varying(255),
    company_name character varying(255),
    contact_email character varying(255),
    contact_firstname character varying(255),
    contact_lastname character varying(255),
    contact_phone character varying(255),
    country character varying(255),
    is_default boolean,
    sca_user_id bigint,
    state character varying(255),
    zip integer,
    address_type_id bigint
);


ALTER TABLE public.sca_address OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 62633)
-- Name: sca_address_address_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sca_address_address_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sca_address_address_id_seq OWNER TO postgres;

--
-- TOC entry 3019 (class 0 OID 0)
-- Dependencies: 215
-- Name: sca_address_address_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sca_address_address_id_seq OWNED BY public.sca_address.address_id;


--
-- TOC entry 218 (class 1259 OID 62646)
-- Name: sca_file; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sca_file (
    file_id bigint NOT NULL,
    created_by bigint,
    created_date timestamp without time zone,
    entity_status_id integer,
    is_active boolean,
    updated_by bigint,
    updated_date timestamp without time zone,
    file_download_uri character varying(255),
    file_name character varying(255),
    file_size bigint,
    file_type character varying(255)
);


ALTER TABLE public.sca_file OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 62644)
-- Name: sca_file_file_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sca_file_file_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sca_file_file_id_seq OWNER TO postgres;

--
-- TOC entry 3020 (class 0 OID 0)
-- Dependencies: 217
-- Name: sca_file_file_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sca_file_file_id_seq OWNED BY public.sca_file.file_id;


--
-- TOC entry 220 (class 1259 OID 62657)
-- Name: sca_order; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sca_order (
    order_id bigint NOT NULL,
    created_by bigint,
    created_date timestamp without time zone,
    entity_status_id integer,
    is_active boolean,
    updated_by bigint,
    updated_date timestamp without time zone,
    billing_address_id bigint,
    calculated_tax double precision,
    credit_card_id bigint,
    designer_address_id bigint,
    order_notification_id integer,
    order_number character varying(255),
    order_sub_total double precision,
    order_total double precision,
    project_id character varying(255),
    promised_ship_date timestamp without time zone,
    promo_code character varying(255),
    resale_number character varying(255),
    sca_user_id bigint,
    shipping_account_number integer,
    shipping_address_id bigint,
    shipping_charges double precision,
    shipping_method integer,
    shipping_notes character varying(255),
    submit_to_fems boolean,
    tax_exempt_cert_number character varying(255),
    tax_exempt_outside_california character varying(255),
    taxable boolean,
    user_id character varying(255),
    wq_number character varying(255)
);


ALTER TABLE public.sca_order OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 62655)
-- Name: sca_order_order_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sca_order_order_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sca_order_order_id_seq OWNER TO postgres;

--
-- TOC entry 3021 (class 0 OID 0)
-- Dependencies: 219
-- Name: sca_order_order_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sca_order_order_id_seq OWNED BY public.sca_order.order_id;


--
-- TOC entry 222 (class 1259 OID 62668)
-- Name: sca_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sca_user (
    sca_user_id bigint NOT NULL,
    created_by bigint,
    created_date timestamp without time zone,
    entity_status_id integer,
    is_active boolean,
    updated_by bigint,
    updated_date timestamp without time zone,
    address_line1 character varying(255),
    address_line2 character varying(255),
    city character varying(255),
    company_name character varying(255),
    country character varying(255),
    email character varying(255),
    fax character varying(255),
    first_name character varying(255),
    job_title character varying(255),
    last_login_date character varying(255),
    last_name character varying(255),
    last_order_date character varying(255),
    life_cycle_tag character varying(255),
    logout_date character varying(255),
    marke_to_score character varying(255),
    member_id character varying(255),
    password character varying(255),
    phone_number character varying(255),
    refresh_token character varying(255),
    sdr_name character varying(255),
    state character varying(255),
    user_id character varying(255),
    web_account_manager_name character varying(255),
    web_account_manager_phone character varying(255),
    web_account_manager_email character varying(255),
    zip character varying(255)
);


ALTER TABLE public.sca_user OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 62666)
-- Name: sca_user_sca_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sca_user_sca_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sca_user_sca_user_id_seq OWNER TO postgres;

--
-- TOC entry 3022 (class 0 OID 0)
-- Dependencies: 221
-- Name: sca_user_sca_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sca_user_sca_user_id_seq OWNED BY public.sca_user.sca_user_id;


--
-- TOC entry 224 (class 1259 OID 62679)
-- Name: service; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.service (
    service_id integer NOT NULL,
    service_desc character varying(255),
    service_name character varying(50) NOT NULL
);


ALTER TABLE public.service OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 62687)
-- Name: service_category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.service_category (
    service_category_id integer NOT NULL,
    created_by bigint,
    created_date timestamp without time zone,
    entity_status_id integer,
    is_active boolean,
    updated_by bigint,
    updated_date timestamp without time zone,
    service_category_external_name character varying(150) NOT NULL,
    service_category_internal_name character varying(150) NOT NULL
);


ALTER TABLE public.service_category OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 62685)
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
-- TOC entry 3023 (class 0 OID 0)
-- Dependencies: 225
-- Name: service_category_service_category_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.service_category_service_category_id_seq OWNED BY public.service_category.service_category_id;


--
-- TOC entry 223 (class 1259 OID 62677)
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
-- TOC entry 3024 (class 0 OID 0)
-- Dependencies: 223
-- Name: service_service_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.service_service_id_seq OWNED BY public.service.service_id;


--
-- TOC entry 227 (class 1259 OID 62693)
-- Name: shipping_method; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.shipping_method (
    shipping_method_id integer NOT NULL,
    display_name character varying(255),
    name character varying(255)
);


ALTER TABLE public.shipping_method OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 62701)
-- Name: shipping_rate; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.shipping_rate (
    shipping_rate_id integer NOT NULL,
    country_id integer,
    shipping_method_id integer,
    shipping_price bigint,
    state_id integer
);


ALTER TABLE public.shipping_rate OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 62706)
-- Name: state; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.state (
    state_id integer NOT NULL,
    display_name character varying(255),
    name character varying(255),
    country_id integer
);


ALTER TABLE public.state OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 62714)
-- Name: user_login; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_login (
    sca_user_id bigint NOT NULL,
    access_token character varying(255),
    login_date timestamp without time zone,
    logout_date timestamp without time zone,
    session_id character varying(255)
);


ALTER TABLE public.user_login OWNER TO postgres;

--
-- TOC entry 2812 (class 2604 OID 62543)
-- Name: credit_card credit_card_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.credit_card ALTER COLUMN credit_card_id SET DEFAULT nextval('public.credit_card_credit_card_id_seq'::regclass);


--
-- TOC entry 2813 (class 2604 OID 62562)
-- Name: entity_additional_info entity_additional_info_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.entity_additional_info ALTER COLUMN entity_additional_info_id SET DEFAULT nextval('public.entity_additional_info_entity_additional_info_id_seq'::regclass);


--
-- TOC entry 2814 (class 2604 OID 62578)
-- Name: job job_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job ALTER COLUMN job_id SET DEFAULT nextval('public.job_job_id_seq'::regclass);


--
-- TOC entry 2815 (class 2604 OID 62589)
-- Name: job_trigger trigger_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_trigger ALTER COLUMN trigger_id SET DEFAULT nextval('public.job_trigger_trigger_id_seq'::regclass);


--
-- TOC entry 2816 (class 2604 OID 62605)
-- Name: order_notification order_notification_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_notification ALTER COLUMN order_notification_id SET DEFAULT nextval('public.order_notification_order_notification_id_seq'::regclass);


--
-- TOC entry 2817 (class 2604 OID 62627)
-- Name: quote_cache_data quote_cache_data_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quote_cache_data ALTER COLUMN quote_cache_data_id SET DEFAULT nextval('public.quote_cache_data_quote_cache_data_id_seq'::regclass);


--
-- TOC entry 2818 (class 2604 OID 62638)
-- Name: sca_address address_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sca_address ALTER COLUMN address_id SET DEFAULT nextval('public.sca_address_address_id_seq'::regclass);


--
-- TOC entry 2819 (class 2604 OID 62649)
-- Name: sca_file file_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sca_file ALTER COLUMN file_id SET DEFAULT nextval('public.sca_file_file_id_seq'::regclass);


--
-- TOC entry 2820 (class 2604 OID 62660)
-- Name: sca_order order_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sca_order ALTER COLUMN order_id SET DEFAULT nextval('public.sca_order_order_id_seq'::regclass);


--
-- TOC entry 2821 (class 2604 OID 62671)
-- Name: sca_user sca_user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sca_user ALTER COLUMN sca_user_id SET DEFAULT nextval('public.sca_user_sca_user_id_seq'::regclass);


--
-- TOC entry 2822 (class 2604 OID 62682)
-- Name: service service_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.service ALTER COLUMN service_id SET DEFAULT nextval('public.service_service_id_seq'::regclass);


--
-- TOC entry 2823 (class 2604 OID 62690)
-- Name: service_category service_category_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.service_category ALTER COLUMN service_category_id SET DEFAULT nextval('public.service_category_service_category_id_seq'::regclass);


--
-- TOC entry 2825 (class 2606 OID 62529)
-- Name: address_type address_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.address_type
    ADD CONSTRAINT address_type_pkey PRIMARY KEY (address_type_id);


--
-- TOC entry 2827 (class 2606 OID 62537)
-- Name: country country_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.country
    ADD CONSTRAINT country_pkey PRIMARY KEY (country_id);


--
-- TOC entry 2829 (class 2606 OID 62548)
-- Name: credit_card credit_card_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.credit_card
    ADD CONSTRAINT credit_card_pkey PRIMARY KEY (credit_card_id);


--
-- TOC entry 2831 (class 2606 OID 62556)
-- Name: credit_card_type credit_card_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.credit_card_type
    ADD CONSTRAINT credit_card_type_pkey PRIMARY KEY (credit_card_type_id);


--
-- TOC entry 2833 (class 2606 OID 62567)
-- Name: entity_additional_info entity_additional_info_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.entity_additional_info
    ADD CONSTRAINT entity_additional_info_pkey PRIMARY KEY (entity_additional_info_id);


--
-- TOC entry 2835 (class 2606 OID 62572)
-- Name: entity_status entity_status_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.entity_status
    ADD CONSTRAINT entity_status_pkey PRIMARY KEY (entity_status_id);


--
-- TOC entry 2837 (class 2606 OID 62583)
-- Name: job job_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job
    ADD CONSTRAINT job_pkey PRIMARY KEY (job_id);


--
-- TOC entry 2843 (class 2606 OID 62594)
-- Name: job_trigger job_trigger_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_trigger
    ADD CONSTRAINT job_trigger_pkey PRIMARY KEY (trigger_id);


--
-- TOC entry 2847 (class 2606 OID 62599)
-- Name: language language_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.language
    ADD CONSTRAINT language_pkey PRIMARY KEY (language_id);


--
-- TOC entry 2849 (class 2606 OID 62610)
-- Name: order_notification order_notification_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_notification
    ADD CONSTRAINT order_notification_pkey PRIMARY KEY (order_notification_id);


--
-- TOC entry 2851 (class 2606 OID 62621)
-- Name: projects projects_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projects
    ADD CONSTRAINT projects_pkey PRIMARY KEY (project_id);


--
-- TOC entry 2853 (class 2606 OID 62632)
-- Name: quote_cache_data quote_cache_data_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quote_cache_data
    ADD CONSTRAINT quote_cache_data_pkey PRIMARY KEY (quote_cache_data_id);


--
-- TOC entry 2855 (class 2606 OID 62643)
-- Name: sca_address sca_address_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sca_address
    ADD CONSTRAINT sca_address_pkey PRIMARY KEY (address_id);


--
-- TOC entry 2857 (class 2606 OID 62654)
-- Name: sca_file sca_file_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sca_file
    ADD CONSTRAINT sca_file_pkey PRIMARY KEY (file_id);


--
-- TOC entry 2859 (class 2606 OID 62665)
-- Name: sca_order sca_order_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sca_order
    ADD CONSTRAINT sca_order_pkey PRIMARY KEY (order_id);


--
-- TOC entry 2861 (class 2606 OID 62676)
-- Name: sca_user sca_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sca_user
    ADD CONSTRAINT sca_user_pkey PRIMARY KEY (sca_user_id);


--
-- TOC entry 2869 (class 2606 OID 62692)
-- Name: service_category service_category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.service_category
    ADD CONSTRAINT service_category_pkey PRIMARY KEY (service_category_id);


--
-- TOC entry 2867 (class 2606 OID 62684)
-- Name: service service_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.service
    ADD CONSTRAINT service_pkey PRIMARY KEY (service_id);


--
-- TOC entry 2875 (class 2606 OID 62700)
-- Name: shipping_method shipping_method_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.shipping_method
    ADD CONSTRAINT shipping_method_pkey PRIMARY KEY (shipping_method_id);


--
-- TOC entry 2877 (class 2606 OID 62705)
-- Name: shipping_rate shipping_rate_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.shipping_rate
    ADD CONSTRAINT shipping_rate_pkey PRIMARY KEY (shipping_rate_id);


--
-- TOC entry 2879 (class 2606 OID 62713)
-- Name: state state_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.state
    ADD CONSTRAINT state_pkey PRIMARY KEY (state_id);


--
-- TOC entry 2863 (class 2606 OID 62729)
-- Name: sca_user uk_1rrupcagx1vrbkfrubfh558ou; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sca_user
    ADD CONSTRAINT uk_1rrupcagx1vrbkfrubfh558ou UNIQUE (email);


--
-- TOC entry 2871 (class 2606 OID 62735)
-- Name: service_category uk_75mp61x5b2102y8u7ngp1b1fb; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.service_category
    ADD CONSTRAINT uk_75mp61x5b2102y8u7ngp1b1fb UNIQUE (service_category_internal_name);


--
-- TOC entry 2873 (class 2606 OID 62733)
-- Name: service_category uk_dh7qbtbu57l92xtlh2eysmtri; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.service_category
    ADD CONSTRAINT uk_dh7qbtbu57l92xtlh2eysmtri UNIQUE (service_category_external_name);


--
-- TOC entry 2839 (class 2606 OID 62723)
-- Name: job uk_ev53855nujsxfyh398s2luimy; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job
    ADD CONSTRAINT uk_ev53855nujsxfyh398s2luimy UNIQUE (job_class);


--
-- TOC entry 2845 (class 2606 OID 62727)
-- Name: job_trigger uk_fcm5nrpgc1h7nyd283re8r0ek; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_trigger
    ADD CONSTRAINT uk_fcm5nrpgc1h7nyd283re8r0ek UNIQUE (job_id);


--
-- TOC entry 2841 (class 2606 OID 62725)
-- Name: job uk_lh567beygpqwd21gmiodslyxx; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job
    ADD CONSTRAINT uk_lh567beygpqwd21gmiodslyxx UNIQUE (job_name);


--
-- TOC entry 2865 (class 2606 OID 62731)
-- Name: sca_user uk_qymqkiotx214cqib4ydc89wha; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sca_user
    ADD CONSTRAINT uk_qymqkiotx214cqib4ydc89wha UNIQUE (member_id);


--
-- TOC entry 2881 (class 2606 OID 62721)
-- Name: user_login user_login_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_login
    ADD CONSTRAINT user_login_pkey PRIMARY KEY (sca_user_id);


--
-- TOC entry 2885 (class 2606 OID 62751)
-- Name: sca_address fk7re32anx0hd6ug7aeh5omldrf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sca_address
    ADD CONSTRAINT fk7re32anx0hd6ug7aeh5omldrf FOREIGN KEY (address_type_id) REFERENCES public.address_type(address_type_id);


--
-- TOC entry 2886 (class 2606 OID 62756)
-- Name: state fkghic7mqjt6qb9vq7up7awu0er; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.state
    ADD CONSTRAINT fkghic7mqjt6qb9vq7up7awu0er FOREIGN KEY (country_id) REFERENCES public.country(country_id);


--
-- TOC entry 2884 (class 2606 OID 62746)
-- Name: project_properties fklf8vnssrqpnwfk9lq9vakkmt6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_properties
    ADD CONSTRAINT fklf8vnssrqpnwfk9lq9vakkmt6 FOREIGN KEY (project_id) REFERENCES public.projects(project_id);


--
-- TOC entry 2883 (class 2606 OID 62741)
-- Name: credit_card fkmaqiox7gydmhi4ci0er3xwres; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.credit_card
    ADD CONSTRAINT fkmaqiox7gydmhi4ci0er3xwres FOREIGN KEY (sca_user_id) REFERENCES public.sca_user(sca_user_id);


--
-- TOC entry 2882 (class 2606 OID 62736)
-- Name: credit_card fkog0g6i44jc5gqc5otsuu3q47c; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.credit_card
    ADD CONSTRAINT fkog0g6i44jc5gqc5otsuu3q47c FOREIGN KEY (credit_card_type_id) REFERENCES public.credit_card_type(credit_card_type_id);


-- Completed on 2020-08-18 14:09:57

--
-- PostgreSQL database dump complete
--

