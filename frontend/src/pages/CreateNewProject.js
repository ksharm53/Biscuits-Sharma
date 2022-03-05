import { useState } from "react";

function CreateNewProject() {
  const [name, setName] = useState("");
  const [connectSlackChannel, setConnectSlackChannel] = useState();
  const [taiga, setTaiga] = useState();
  const [teamMembers, setTeamMembers] = useState();
  const [teamMembersString, setTeamMembersString] = useState();
  const [description, setDescription] = useState("");
  const [githubUrl, setGithubUrl] = useState("");
  const [slackChannel, setSlackChannel] = useState("");
  const [slackToken, setSlackToken] = useState("");

  function onNameChange(event) {
    setName(event.target.value);
  }

  function onDescriptionChange(event) {
    setDescription(event.target.value);
  }

  function onSlackConnectChange(e) {
    setConnectSlackChannel(e.target.value);
  }

  function onSetTaigaChange(e) {
    setTaiga(e.target.value);
  }

  function onSetTeamMembersChange(e) {
    setTeamMembers(e.target.value);
  }

  async function onFormSubmit(e) {
    // call api
    e.preventDefault();
    const data = {
      name,
      description,
      github: githubUrl,
      team_members: teamMembersString,
      slack_channel: slackChannel,
      slackToken: slackToken,
      taiga,
    };

    const rawResponse = await fetch("http://localhost:8000/create", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    });
    const content = await rawResponse.json();

    alert(content.message);
  }

  return (
    <div>
      <form style={{ padding: "10px 20px" }} onSubmit={onFormSubmit}>
        <input
          placeholder="Enter project name"
          value={name}
          onChange={onNameChange}
        />
        <br />
        <input
          placeholder="Enter project description"
          value={description}
          onChange={onDescriptionChange}
        />
        <br />
        <p>Do you want team members?</p>
        <input
          type="radio"
          name="team"
          value="true"
          checked={teamMembers === "true"}
          onChange={onSetTeamMembersChange}
        />{" "}
        Yes
        <br />
        <input
          name="team"
          type="radio"
          value="false"
          checked={teamMembers === "false"}
          onChange={onSetTeamMembersChange}
        />{" "}
        No
        {teamMembers === "true" && (
          <div>
            <p>Add team members (comma seperated)</p>
            <textarea
              value={teamMembersString}
              onChange={(e) => setTeamMembersString(e.target.value)}
            />
          </div>
        )}
        <br />
        <p>Github URL</p>
        <input
          type="text"
          value={githubUrl}
          onChange={(e) => setGithubUrl(e.target.value)}
        />
        <br />
        <p>Do you want to connect with Slack channel?</p>
        <input
          type="radio"
          value="true"
          name="slack-channel"
          checked={connectSlackChannel === "true"}
          onChange={onSlackConnectChange}
        />{" "}
        Yes
        <br />
        <input
          type="radio"
          value="false"
          name="slack-channel"
          checked={connectSlackChannel === "false"}
          onChange={onSlackConnectChange}
        />{" "}
        No
        {connectSlackChannel === "true" && (
          <div>
            <p>Slack channel name (add '#')</p>
            <input
              type="text"
              value={slackChannel}
              onChange={(e) => setSlackChannel(e.target.value)}
            />

            <p>Slack token</p>
            <input
              type="text"
              value={slackToken}
              onChange={(e) => setSlackToken(e.target.value)}
            />
          </div>
        )}
        <br />
        <p>Do you want to add this Project to Taiga?</p>
        <input
          type="radio"
          value="true"
          name="taiga"
          checked={taiga === "true"}
          onChange={onSetTaigaChange}
        />{" "}
        Yes
        <br />
        <input
          type="radio"
          value="false"
          name="taiga"
          checked={taiga === "false"}
          onChange={onSetTaigaChange}
        />{" "}
        No
        <br />
        <br />
        <button>Save</button>
      </form>
    </div>
  );
}

export default CreateNewProject;
