package com.puzzle.address.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class BusinessCardDto {
    public static class Get {
        @Getter
        @NoArgsConstructor
        @Schema(name = "BusinessCardDto.Get.Response")
        public static class Response {
            private String email;
            private String name;
            private String rank;
            private String phoneNumber;
            private String companyName;
            private String companyUrl;
            private String companyAddress;

            public Response(com.puzzle.address.domain.BusinessCard businessCard) {
                this.name = businessCard.getName();
                this.email = businessCard.getEmail();
                this.rank = businessCard.getRank();
                this.phoneNumber = businessCard.getPhoneNumber();
                this.companyName = businessCard.getCompanyName();
                this.companyUrl = businessCard.getCompanyUrl();
                this.companyAddress = businessCard.getCompanyAddress();
            }
        }
    }

    public static class Update {
        @Getter
        @Schema(name = "BusinessCardDto.Update.Request")
        public static class Request {
            @NotEmpty
            private String name;
            @NotEmpty
            @Email
            private String email;
            private String rank;
            private String phoneNumber;
            private String companyName;
            private String companyUrl;
            private String companyAddress;
        }
    }

    @Getter
    @NoArgsConstructor
    @Schema(name = "BusinessCardDto.BusinessCard")
    public static class BusinessCard {
        private String uuid;
        private String name;
        private String email;
        private String rank;
        private String phoneNumber;
        private String department;
        private String companyName;
        private String companyUrl;
        private String companyAddress;

        public BusinessCard(final com.puzzle.address.domain.BusinessCard businessCard) {
            this.uuid = businessCard.getUuid();
            this.name = businessCard.getName();
            this.email = businessCard.getEmail();
            this.rank = businessCard.getRank();
            this.department = businessCard.getDepartment();
            this.phoneNumber = businessCard.getPhoneNumber();
            this.companyName = businessCard.getCompanyName();
            this.companyUrl = businessCard.getCompanyUrl();
            this.companyAddress = businessCard.getCompanyAddress();
        }
    }
}
