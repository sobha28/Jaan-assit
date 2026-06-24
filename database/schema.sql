-- ═══════════════════════════════════════════════
--  JAN-ASSIST  —  Government Schemes Database
--  Run this ONCE to initialise; Hibernate will
--  then manage schema via ddl-auto=update
-- ═══════════════════════════════════════════════
CREATE DATABASE IF NOT EXISTS gov_schemes
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE gov_schemes;

-- ────────────────────────────────────────────────
--  SCHEMES  (seeded by Spring Boot on first run)
-- ────────────────────────────────────────────────
CREATE TABLE IF NOT EXISTS schemes (
    id                  BIGINT       AUTO_INCREMENT PRIMARY KEY,
    scheme_name         VARCHAR(255) NOT NULL,
    category            VARCHAR(100) NOT NULL,
    description         TEXT,
    eligibility         TEXT,
    official_website_url VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ────────────────────────────────────────────────
--  USERS  (populated on every form submission)
-- ────────────────────────────────────────────────
CREATE TABLE IF NOT EXISTS users (
    id              BIGINT       AUTO_INCREMENT PRIMARY KEY,
    name            VARCHAR(255) NOT NULL,
    age             INT,
    gender          VARCHAR(20),
    occupation      VARCHAR(100),
    income          DOUBLE,
    category        VARCHAR(100),
    state           VARCHAR(100),
    contact_number  VARCHAR(20),
    submission_date DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;