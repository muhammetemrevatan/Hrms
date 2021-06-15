import React, { useState, useEffect } from "react";
import * as Yup from "yup";
import { useFormik } from "formik";
import { Button, Form, Label, Icon } from "semantic-ui-react";
import JobAdvertisementService from "../services/jobAdvertisementService";
import CityService from "../services/cityService";
import JobPositionService from "../services/jobPositionService";
import WorkTypeService from "../services/workTypeService";
import WayOfWorkService from "../services/wayOfWorkService";

export default function JobAdvertisementForm() {
  const [cities, setCities] = useState([]);
  const [jobPositions, setjobPositions] = useState([]);
  const [workTypes, setworkTypes] = useState([]);
  const [wayOfWorks, setwayOfWorks] = useState([]);

  useEffect(() => {
    let cityService = new CityService();
    cityService.getCity().then((result) => setCities(result.data.data));

    let jobPositionService = new JobPositionService();
    jobPositionService
      .getJobPosition()
      .then((result) => setjobPositions(result.data.data));

    let workTypeService = new WorkTypeService();
    workTypeService
      .getWorkType()
      .then((result) => setworkTypes(result.data.data));

    let wayOfWorkService = new WayOfWorkService();
    wayOfWorkService
      .getWayOfWork()
      .then((result) => setwayOfWorks(result.data.data));
  }, []);

  const {
    values,
    errors,
    handleChange,
    handleSubmit,
    isSubmitting,
    touched,
  } = useFormik({
    initialValues: {
      cityId: "",
      deadline: "",
      employerId: "",
      jobDescription: "",
      jobPositionId: "",
      salaryMin: "",
      salaryMax: "",
      openPositionNumber: "",
      workTypeId: "",
      wayOfWorkId: "",
    },
    validationSchema: Yup.object({
      jobDescription: Yup.string()
        .required("Zorunlu Alan!")
        .min(10, "İş tanımı alanı en az 10 karakter olmalıdır."),
      salaryMin: Yup.number()
        .typeError("Lütfen tam sayı giriniz."),
      salaryMax: Yup.number()
        .typeError("Lütfen tam sayı giriniz."),
      openPositionNumber: Yup.number()
        .required("Zorunlu Alan!")
        .typeError("Lütfen tam sayı giriniz."),
      deadline: Yup.string().required("Zorunlu Alan!"),
      workTypeId: Yup.number().required("Zorunlu Alan!"),
      wayOfWorkId: Yup.number().required("Zorunlu Alan!"),
      employerId: Yup.number().required("Zorunlu Alan!"),
      jobPositionId: Yup.string().required("Zorunlu Alan!"),
      cityId: Yup.number().required("Zorunlu Alan!"),
    }),
    onSubmit: (values) => {
      let jobadvertisementService = new JobAdvertisementService();
      jobadvertisementService.add(values).then();
    },
  });

  return (
    <div>
      <Form
        onSubmit={handleSubmit}
        style={{ margin: "4em 2em 2em 1em", padding: "2em 0em 1em 2em" }}
      >
        <h1>İş İlanı Ekle</h1>

        <hr />
        <br />
        <Form.Field>
            <label>İşveren Id</label>
            <input
              name="employerId"
              value={values.employerId}
              onChange={handleChange}
              placeholder="İşveren"
            />
            {errors.employerId && touched.employerId && (
              <Label pointing prompt><Icon name="close"/>{errors.employerId}</Label>
            )}
          </Form.Field>
          <Form.Field>
            <label>Şehir</label>
            <select
              id="cityId"
              onChange={handleChange}
              value={values.cityId}
              name="cityId"
            >
              <option value="">--</option>
              {cities.map((city) => (
                <option key={city.id} value={city.id}>
                  {city.city}
                </option>
              ))}
              
            </select>
            {errors.cityId && touched.cityId && (
              <Label pointing prompt><Icon name="close"/>{errors.cityId}</Label>
            )}
            
          </Form.Field>
          <Form.Group widths="equal">
          <Form.Field>
            <label>İş Tipi</label>
            <select
              id="workTypeId"
              onChange={handleChange}
              value={values.workTypeId}
              name="workTypeId"
            >
              <option value="">--</option>
              {workTypes.map((workType) => (
                <option key={workType.id} value={workType.id}>
                  {workType.name}
                </option>
              ))}
            </select>

            {errors.workTypeId && touched.workTypeId && (
              <Label pointing prompt><Icon name="close"/>{errors.workTypeId}</Label>
            )}
          </Form.Field>
          <Form.Field>
            <label>İş Pozisyonu</label>
            <select
              id="jobPositionId"
              onChange={handleChange}
              value={values.jobPositionId}
              name="jobPositionId"
            >
              <option value="">--</option>
              {jobPositions.map((jobPosition) => (
                <option key={jobPosition.id} value={jobPosition.id}>
                  {jobPosition.position}
                </option>
              ))}
            </select>

            {errors.jobPositionId && touched.jobPositionId && (
              <Label pointing prompt><Icon name="close"/>{errors.jobPositionId}</Label>
            )}
          </Form.Field>
          <Form.Field>
            <label>Çalışma Zamanı</label>
            <select
              id="wayOfWorkId"
              onChange={handleChange}
              value={values.wayOfWorkId}
              name="wayOfWorkId"
            >
              <option value="">--</option>
              {wayOfWorks.map((wayOfWork) => (
                <option key={wayOfWork.id} value={wayOfWork.id}>
                  {wayOfWork.name}
                </option>
              ))}
            </select>

            {errors.workTypeId && touched.workTypeId && (
              <Label pointing prompt><Icon name="close"/>{errors.wayOfWorkId}</Label>
            )}
          </Form.Field>
          </Form.Group>

        <Form.Group widths="equal">
        
          <Form.Field>
            <label>Minimum Maaş</label>
            <input
              name="salaryMin"
              placeholder="Minimum Maaş"
              value={values.salaryMin}
              onChange={handleChange}
            />
            {errors.salaryMin && touched.salaryMin && (
              <Label pointing prompt><Icon name="close"/>{errors.salaryMin}</Label>
            )}
          </Form.Field>

          <Form.Field>
            <label>Maksimum Maaş</label>
            <input
              name="salaryMax"
              placeholder="Maksimum Maaş"
              value={values.salaryMax}
              onChange={handleChange}
            />
            {errors.salaryMax && touched.salaryMax && (
              <Label pointing prompt><Icon name="close"/>{errors.salaryMax}</Label>
            )}
          </Form.Field>

        </Form.Group>
          <Form.Field>
            <label>Açık Pozisyon Sayısı</label>
            <input
              name="openPositionNumber"
              placeholder="Açık Pozisyon Sayısı"
              value={values.openPositionNumber}
              onChange={handleChange}
            />
            {errors.openPositionNumber && touched.openPositionNumber && (
              <Label pointing prompt><Icon name="close"/>{errors.openPositionNumber}</Label>
            )}
          </Form.Field>
          <Form.Field>
            <label>Son Başvuru Tarihi</label>
            <input
              name="deadline"
              type="date"
              value={values.deadline}
              onChange={handleChange}
            />
            {errors.deadline && touched.deadline && (
              <Label pointing prompt><Icon name="close"/>{errors.deadline}</Label>
            )}
          </Form.Field>

        <Form.Field>
          <Form.TextArea
            name="jobDescription"
            placeholder="İş hakkında biraz daha detay verin.." 
            value={values.jobDescription}
            onChange={handleChange}
            label="Açıklama"
          >
          </Form.TextArea>
            {errors.jobDescription && touched.jobDescription && (
            <Label pointing prompt >
              <Icon name="close"/>
              {errors.jobDescription}
              </Label>
          )}
          
          
        </Form.Field>

        <Button
          type="submit"
          disabled={isSubmitting}
          color="teal"
          content="İlanı Yayınla"
          icon="add circle"
          labelPosition="left"
        />
        <Button
          type="submit"
          color="yellow"
          content="Temizle"
          icon="trash alternate outline"
          labelPosition="left"
        />
        <Button
          type="submit"
          color="red"
          content="Vazgeç"
          icon="close"
          labelPosition="left"
        />
      </Form>
    </div>
  );
}
