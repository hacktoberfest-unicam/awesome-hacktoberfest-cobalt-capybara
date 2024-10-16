[Link docs challenges](https://docs.google.com/document/d/1snsqBfRR-UTHfbXY8euCrLMi-uokF9phZtwXvVml5FE/edit)


# Awesome Hacktoberfest Cobalt Capybara
<p align="center">
  <img src=".github/img/cobalt_capybara.png" height="300">
</p>
<p align="center">
Hackathon Repository: Unicam Hacktoberfest v5.0 2024 (code name: Cobalt Capybara), a computer science event aimed at bringing people together and fostering collaboration and creativity through the discovery of Open Source at the University of Camerino campus.

  <br>
  <b>
      <a href="https://www.unicam.it/">Unicam</a> • 
      <a href="https://hacktoberfest.com/">Evento</a> • 
      <a href="LICENSE">Licenza</a>
  </b>
</p>

---

## Gyms
- [**Palestra di Edsger Dijkstra (ASD)**](./Palestra%20di%20Edsger%20Dijkstra%20(ASD))
- [**Palestra di Dennis Ritchie (IMP)**](./Palestra%20di%20Dennis%20Ritchie%20(IMP))
- [**Palestra di Barbara Liskov (OOP)**](./Palestra%20di%20Barbara%20Liskov%20(OOP))
- [**Palestra di Haskell Curry (FUN)**](./Palestra%20di%20Haskell%20Curry%20(FUN))
- [**Palestra di Donald Norman (UI/UX)**](./Palestra%20di%20Donald%20Norman%20(UI%5CUX))
- [**Palestra di Shigeru Miyamoto (GAME DEV)**](./Palestra%20di%20Shigeru%20Miyamoto%20(GAME%20DEV))
- [**Palestra di Tim Berners-Lee (WEB DEV)**](./Palestra%20di%20Tim%20Berners-Lee%20(WEB%20DEV))

## Secret Routes
- [**Logo Contest**](./Secret%20Route%20(LOGO%20CONTEST))
- [**Social Challenge**](./Secret%20Route%20(SOCIAL%20CHALLENGE))
- [**Video Game Development Contest**](./Secret%20Route%20(VIDEOGAME%20DEVELOPMENT%20CONTEST))

### How to fork
* Once you're on the repository page, you will see a button in the upper right-hand corner that says "Fork." Click it.
* After clicking the "Fork" button, GitHub will prompt you to choose where to fork the repository. You can choose to fork it to your personal account or to an organization that you are a member of. Select your account.
* You will be redirected to your forked repository page on GitHub. It's a copy of the original repository, and you have full control over it. Enjoy!

### How to contribute
* Clone your fork locally (replace `<USERNAME>` with your GitHub username)
  ```
  git clone https://github.com/<USERNAME>/awesome-hacktoberfest-cadmium-capibara
  ```
* Create a new branch for each challenge you want to work on with this command (just make sure it's a different name for each gym)
  ```
  git checkout main
  git checkout -b my_problem_01
  ```
* Make the necessary code changes in your local repository.
* To stage your changes for commit, use the "git add" command. You can specify individual files or use a wildcard to stage all changes:
  ```
  git add file1.js file2.js
  # or to stage all changes
  git add .
  ```

### How to write commit messages
* Commit your staged changes with a descriptive commit message:
  ```
  git commit -m "[add] Added new file1.py to add new feature"
  # or based on the various labels
  git commit -m "[edit] Edited file1.py to fix these bugs"
  git commit -m "[remove] Removed file1.py because it is no longer used"
  ```

### How to update your changes into your repo on GitHub
* Push your branch with the new commit(s) to your fork on GitHub:
  ```
  git push origin [branch_name]
  ```

### How to create a PR
* Go to your fork on GitHub and switch to the branch you just pushed.
* Click on the "New Pull Request" button. GitHub will guide you through creating a pull request. Make sure your pull request is pointing to the `hackathon` branch. Provide a clear title and description for your changes.

NOTE: check your Pull Request because during the review process, we may comment on it to request changes or fixes.
