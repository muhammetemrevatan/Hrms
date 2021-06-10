import React from "react";
import { Route } from "react-router";
import { Container, Grid } from "semantic-ui-react";
import CandidateList from "../pages/CandidateList";
import EmployerList from "../pages/EmployerList";
import JobAdvertisementList from "../pages/JobAdvertisementList";
import JobPositionList from "../pages/JobPositionList";
import JobFilter from "./JobFilter";

export default function Dashboard() {
  return (
    <div className="backgroundimagesirket">
      <JobFilter/>

      <Container >
        <Grid>
          <Grid.Row>
            <Grid.Column width={3}>
            </Grid.Column>
            <Grid.Column width={13}>
              <Route exact path="/" component={JobAdvertisementList} />
              <Route exact path="/jobadvertisements" component={JobAdvertisementList}/>
              <Route exact path="/candidates" component={CandidateList}/>
              <Route exact path="/employers" component={EmployerList}/>
              <Route exact path="/jobpositions" component={JobPositionList}/>
            </Grid.Column>
          </Grid.Row>
        </Grid>
      </Container>
      
    </div>
  );
}
