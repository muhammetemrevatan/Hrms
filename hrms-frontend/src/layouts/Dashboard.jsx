import React from "react";
import { Route } from "react-router";
import { Container, Grid } from "semantic-ui-react";
import CandidateList from "../pages/CandidateList";
import EmployerList from "../pages/EmployerList";
import JobAdvertisementList from "../pages/JobAdvertisementList";
import JobPositionList from "../pages/JobPositionList";
import JobAdvertisementConfirmList from "../pages/JobAdvertisementConfirmList";
import JobFilter from "./JobFilter";
import JobAdvertisementForm from "./JobAdvertisementForm";
import SideBar from "../layouts/Sidebar";

export default function Dashboard() {
  return (
    <div className="backgroundimagesirket">
      <Route exact path="/" component={JobFilter} />

      <Container  style={{ margin: "2em 0em 0em 0em", padding: "2em 0em 2em 0em" }}>
        <Route exact path="/jobadvertisementform"component={JobAdvertisementForm}/>
        <Route exact path="/employers" component={EmployerList} />
        <Route exact path="/candidates" component={CandidateList} />
        <Route exact path="/jobpositions" component={JobPositionList} />
        <Route exact path="/" component={JobAdvertisementList} />
        <Route exact path="/jobadvertisements"component={JobAdvertisementList}/>
        <Route exact path="/jobadvertisementsconfirm"component={JobAdvertisementConfirmList}/>
      </Container>

      <Container>
        <Grid>
          <Grid.Row>
            <Grid.Column width={3}>
            <Route exact path="/sidebar" component={SideBar} /> 
            </Grid.Column>
            <Grid.Column width={13}>
              
            </Grid.Column>
          </Grid.Row>
        </Grid>
      </Container>
    </div>
  );
}
