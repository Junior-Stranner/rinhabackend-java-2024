package br.com.jujubaprojects.rinhabackendjava.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExtratoRequestDto {
    
    private Saldo saldo;


    public static class Saldo {

        private int total;

        @JsonProperty("data_extrato")
        private LocalDateTime data;

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
