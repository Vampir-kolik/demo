package com.example;

import java.util.Optional;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

//@Repository
    public class ProfileRepositoryImpl implements ProfileRepository {

        private static final String SQL_GET_PROFILE_BY_ID =
                "select id, first_name, last_name, age from profile where id = :id";

        private final ProfileMapper profileMapper;
        private final NamedParameterJdbcTemplate jdbcTemplate;

        public ProfileRepositoryImpl() {
            ProfileMapper profileMapper2 = new ProfileMapper();
            AppConfig vConf = new AppConfig();
            NamedParameterJdbcTemplate jdbcTemplate2 = new NamedParameterJdbcTemplate(vConf.realDataSource());
            this.profileMapper = profileMapper2;
            this.jdbcTemplate = jdbcTemplate2;
        }

       /*  public ProfileRepositoryImpl(
                ProfileMapper profileMapper,
                NamedParameterJdbcTemplate jdbcTemplate
        ) {
            this.profileMapper = profileMapper;
            this.jdbcTemplate = jdbcTemplate;
        }*/

        @Override
        public Optional<Profile> getProfileById(int id) {
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("id", id);
            return jdbcTemplate.query(
                            SQL_GET_PROFILE_BY_ID,
                            params,
                            profileMapper
                    ).stream()
                    .findFirst();
        }
    }