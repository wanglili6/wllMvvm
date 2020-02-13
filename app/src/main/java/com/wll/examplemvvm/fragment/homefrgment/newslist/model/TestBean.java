package com.wll.examplemvvm.fragment.homefrgment.newslist.model;

import java.util.List;

/**
 * @author wanglili
 * @description:
 * @date : 2020-02-12 16:57
 */
public class TestBean {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * exchange_record_id : 9
         * erp_prize_id : 326
         * exchange_prize_num : 1
         * from_point_id : 1
         * to_point_id : 2
         * to_point_by : 0
         * to_point_name :
         * to_point_at : 2020-02-12 10:21:46
         * create_by : 3394
         * create_by_name : 李朝煌
         * create_at : 2020-02-12 10:21:46
         * exchange_record_status : 0
         */

        private String exchange_record_id;
        private String erp_prize_id;
        private int exchange_prize_num;
        private String from_point_id;
        private String to_point_id;
        private String to_point_by;
        private String to_point_name;
        private String to_point_at;
        private String create_by;
        private String create_by_name;
        private String create_at;
        private String exchange_record_status;

        public String getExchange_record_id() {
            return exchange_record_id;
        }

        public void setExchange_record_id(String exchange_record_id) {
            this.exchange_record_id = exchange_record_id;
        }

        public String getErp_prize_id() {
            return erp_prize_id;
        }

        public void setErp_prize_id(String erp_prize_id) {
            this.erp_prize_id = erp_prize_id;
        }

        public int getExchange_prize_num() {
            return exchange_prize_num;
        }

        public void setExchange_prize_num(int exchange_prize_num) {
            this.exchange_prize_num = exchange_prize_num;
        }

        public String getFrom_point_id() {
            return from_point_id;
        }

        public void setFrom_point_id(String from_point_id) {
            this.from_point_id = from_point_id;
        }

        public String getTo_point_id() {
            return to_point_id;
        }

        public void setTo_point_id(String to_point_id) {
            this.to_point_id = to_point_id;
        }

        public String getTo_point_by() {
            return to_point_by;
        }

        public void setTo_point_by(String to_point_by) {
            this.to_point_by = to_point_by;
        }

        public String getTo_point_name() {
            return to_point_name;
        }

        public void setTo_point_name(String to_point_name) {
            this.to_point_name = to_point_name;
        }

        public String getTo_point_at() {
            return to_point_at;
        }

        public void setTo_point_at(String to_point_at) {
            this.to_point_at = to_point_at;
        }

        public String getCreate_by() {
            return create_by;
        }

        public void setCreate_by(String create_by) {
            this.create_by = create_by;
        }

        public String getCreate_by_name() {
            return create_by_name;
        }

        public void setCreate_by_name(String create_by_name) {
            this.create_by_name = create_by_name;
        }

        public String getCreate_at() {
            return create_at;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
        }

        public String getExchange_record_status() {
            return exchange_record_status;
        }

        public void setExchange_record_status(String exchange_record_status) {
            this.exchange_record_status = exchange_record_status;
        }
    }
}
