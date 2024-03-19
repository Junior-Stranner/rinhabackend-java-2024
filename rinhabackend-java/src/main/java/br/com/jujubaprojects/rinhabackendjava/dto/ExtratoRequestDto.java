package br.com.jujubaprojects.rinhabackendjava.dto;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExtratoRequestDto {
    
    @Range(min = 0, max = 1000000000, message = "O saldo deve estar entre 0 e 1.000.000.000")
    private Saldo saldo;


    public static class Saldo {

        private int total;

        @JsonProperty("data_extrato")
        private LocalDateTime data;

        @Range(min = 0, max = 1000000000, message = "O limite deve estar entre 0 e 1.000.000.000")
        private int limite;

        public void setTotal(int total) {
            this.total = total;
        }

        public void setData(LocalDateTime data) {
            this.data = data;
        }

        public void setLimite(int limite) {
            this.limite = limite;
        }

        public int getTotal() {
            return total;
        }

        public LocalDateTime getData() {
            return data;
        }

        public int getLimite() {
            return limite;
        }
    }
}
