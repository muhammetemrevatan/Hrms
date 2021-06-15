import axios from "axios"

export default class JobAdvertisementService{

    getJobAdvertisementConfirm(){
        return axios.get("http://localhost:8080/api/jobadvertisements/getallactiveandconfirm")
    }

    getJobAdvertisement(){
        return axios.get("http://localhost:8080/api/jobadvertisements/getallsorteddate")
    }


    add(id){
        return axios.post("http://localhost:8080/api/jobadvertisements/add",id);
    }

    setPutJobAdvertisementId(value){
        return axios.put("http://localhost:8080/api/jobadvertisements/confirm/" + value);
    }
}