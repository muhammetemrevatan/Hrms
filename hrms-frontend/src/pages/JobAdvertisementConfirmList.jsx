import React, { useState, useEffect } from "react";
import { Container, Button, Card, Image } from "semantic-ui-react";
import JobAdvertisementService from "../services/jobAdvertisementService";
import Swal from "sweetalert2";

export default function JobAdvertisementConfirm() {
  const [jobAdvertisements, setJobAdvertisements] = useState([]);

  useEffect(() => {
    let jobAdvertisementService = new JobAdvertisementService();
    jobAdvertisementService
      .getJobAdvertisement()
      .then((result) => setJobAdvertisements(result.data.data));
  }, []);

  const handleClick = function (id) {
    let jobAdvertisementService = new JobAdvertisementService();
    jobAdvertisementService.setPutJobAdvertisementId(id).then();

    Swal.fire({
      position: "center",
      icon: "success",
      title: "Your work has been saved",
      showConfirmButton: false,
      timer: 1500,
    });

    setInterval(() => {
      window.location.reload();
    }, 1500);
  };

  return (
    <div>
      <Container
        style={{ margin: "2em 2em 0em 0em", padding: "2em 0em 2em 0em" }}
      >
        {jobAdvertisements
          .filter(
            (jobAdvertisement) => jobAdvertisement.employeeConfirm === false
          )
          .map((jobAdvertisement) => (
            <Card
              style={{ margin: "2em 2em 0em 0em", padding: "2em 0em 2em 0em" }}
              fluid
              key={jobAdvertisement.id}
            >
              <Card.Content>
                <Image
                  floated="left"
                  size="small"
                  src="https://react.semantic-ui.com/images/avatar/large/daniel.jpg"
                  style={{
                    margin: "0em 0em 0em 2em",
                    padding: "0em 0em 1em 0em",
                  }}
                />
                <Card.Header>
                  <strong>{jobAdvertisement.employerCompanyName}</strong>
                </Card.Header>
                <br />
                <Card.Meta>
                  <strong>
                    Pozisyon : {jobAdvertisement.jobPositionPosition}
                  </strong>
                </Card.Meta>
                <Card.Meta>
                  <strong>
                    {" "}
                    Açık Pozisyon Sayısı{jobAdvertisement.openPositionNumber}
                  </strong>
                </Card.Meta>
                <Card.Meta>
                  <strong> Son başvuru : {jobAdvertisement.deadline}</strong>
                </Card.Meta>
                <Card.Meta>
                  <strong>
                    {" "}
                    Ücret : {jobAdvertisement.salaryMin} -{" "}
                    {jobAdvertisement.salaryMax}
                  </strong>
                </Card.Meta>
                <Card.Meta>
                  <strong>Açıklama : {jobAdvertisement.jobDescription}</strong>
                </Card.Meta>

                <br />
                <Button
                  color="teal"
                  content="İlanı Onayla"
                  icon="check"
                  labelPosition="left"
                  circular
                  onClick={(e) => handleClick(jobAdvertisement.id)}
                />
              </Card.Content>
            </Card>
          ))}
      </Container>
    </div>
  );
}
