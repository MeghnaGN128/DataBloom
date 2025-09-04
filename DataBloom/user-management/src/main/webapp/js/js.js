function checkname() {
    const name = document.getElementById('regName').value.trim();
    const error = document.getElementById('errorname');
    if (name === "") {
        error.textContent = "Name field is empty";
    } else if (name.length < 4) {
        error.textContent = "Name must be at least 4 characters";
    } else {
        error.textContent = "";
    }
}

function checkmail() {
    const email = document.getElementById('regEmail').value.trim();
    const error = document.getElementById('errormail');
    if (email === "") {
        error.textContent = "Email field is empty";
    } else if (!/^\S+@\S+\.\S+$/.test(email)) {
        error.textContent = "Enter a valid email address";
    } else {
        error.textContent = "";
    }
}

function checkmobile() {
    const mobile = document.getElementById('regPhone').value.trim();
    const error = document.getElementById('errormobile');
    if (mobile === "") {
        error.textContent = "Mobile field is empty";
    } else if (!/^\d{10}$/.test(mobile)) {
        error.textContent = "Enter a valid 10-digit mobile number";
    } else {
        error.textContent = "";
    }
}

function checkaddress() {
    const address = document.getElementById('exampleFormControlTextarea1').value.trim();
    const error = document.getElementById('erroraddress');
    if (address === "") {
        error.textContent = "Address field is empty";
    } else {
        error.textContent = "";
    }
}

function checkpassword() {
    const password = document.getElementById('regPassword').value;
    const confirmPassword = document.getElementById('regConfirmPassword').value;

    const error = document.getElementById('errorpassword');
    const errorconfirm = document.getElementById('errorConfirmpassword');

    if (password === "") {
        error.textContent = "Password field is empty";
    } else if (password.length < 6) {
        error.textContent = "Password must be at least 6 characters";
    } else {
        error.textContent = "";
    }

    if (confirmPassword === "") {
        errorconfirm.textContent = "Confirm password field is empty";
    } else if (password !== confirmPassword) {
        errorconfirm.textContent = "Passwords do not match";
    } else {
        errorconfirm.textContent = "";
    }
}

let countdownInterval;

function startCountdown(durationInMinutes) {
    let time = durationInMinutes * 60;
    const timerEl = document.getElementById("timer");
    const loginBtn = document.getElementById("loginBtn");
    const resendBtn = document.getElementById("resendBtn");

    if (!timerEl || !loginBtn || !resendBtn) {
        console.error("Missing timer/loginBtn/resendBtn element in HTML");
        return;
    }

    loginBtn.disabled = false;
    resendBtn.style.display = "none";

    clearInterval(countdownInterval);

    countdownInterval = setInterval(() => {
        const minutes = Math.floor(time / 60);
        const seconds = time % 60;

        timerEl.innerHTML = OTP valid for: ${minutes}m ${seconds < 10 ? "0" : ""}${seconds}s;

        if (time <= 0) {
            clearInterval(countdownInterval);
            timerEl.innerHTML = "OTP expired!";
            loginBtn.disabled = true;
            resendBtn.style.display = "inline-block";
        }
        time--;
    }, 1000);
}

window.onload = function () {
    if (document.getElementById("timer")) {
        startCountdown(2); // 2 minutes
    }
};

function resendOtp() {
    const emailInput = document.getElementById("loginEmail");
    if (!emailInput) {
        alert("Email input not found");
        return;
    }

    const email = emailInput.value.trim();
    fetch("resend-otp?email=" + encodeURIComponent(email), { method: "POST" })
        .then(res => res.text())
        .then(msg => {
            alert(msg);
            startCountdown(2); // restart countdown
        })
        .catch(err => console.error(err));
}
console.log(" Script loaded");

const stateSelect = document.getElementById("state");
const districtSelect = document.getElementById("district");
const pincodeSelect = document.getElementById("pincode");

fetch(
  "https://raw.githubusercontent.com/Yash-Gaglani/List-of-States-and-Districts-in-India/main/States%20and%20Districts.json"
)
  .then((res) => res.json())
  .then((data) => {
    // Populate states
    data.forEach((item) => {
      const opt = document.createElement("option");
      opt.value = item.stateName;
      opt.text = item.stateName;
      stateSelect.appendChild(opt);
    });

    stateSelect.addEventListener("change", function () {
      const selectedState = this.value;
      districtSelect.innerHTML = '<option value="">Select District</option>';
      pincodeSelect.innerHTML = '<option value="">Select Pincode</option>';

      const stateObj = data.find((item) => item.stateName === selectedState);
      if (stateObj) {
        stateObj.districts.forEach((district) => {
          const opt = document.createElement("option");
          // If district is an object, use district.name; if string, use district
          opt.value = typeof district === "string" ? district : district.name;
          opt.text = typeof district === "string" ? district : district.name;
          districtSelect.appendChild(opt);
        });
      }
    });
  })
  .catch((err) => console.error("Error loading state-district data:", err));

const districtDropdown = document.getElementById("district");
const pincodeDropdown = document.getElementById("pincode");

districtDropdown.addEventListener("change", async () => {
  const district = districtDropdown.value;
  const state = stateSelect.value;
  pincodeDropdown.innerHTML = '<option value="">-- Select Pincode --</option>';
  if (!district || !state) return;

  const url = `https://api.postalpincode.in/postoffice/${encodeURIComponent(
    district
  )}`;

  try {
    const response = await fetch(url);
    const data = await response.json();
    if (
      Array.isArray(data) &&
      data[0].Status === "Success" &&
      Array.isArray(data[0].PostOffice)
    ) {

      const pincodes = data[0].PostOffice.filter(
        (po) => po.State.toLowerCase() === state.toLowerCase()
      ).map((po) => po.Pincode);

      const uniquePincodes = [...new Set(pincodes)];
      if (uniquePincodes.length) {
        uniquePincodes.forEach((pin) => {
          const opt = document.createElement("option");
          opt.value = pin;
          opt.textContent = pin;
          pincodeDropdown.appendChild(opt);
        });
      } else {
        pincodeDropdown.innerHTML = "<option>No pincodes found</option>";
      }
    } else {
      pincodeDropdown.innerHTML = "<option>No pincodes found</option>";
    }
  } catch (err) {
    console.error("Error fetching pincodes:", err);
    pincodeDropdown.innerHTML = "<option>Error loading pincodes</option>";
  }
});

pincodeDropdown.addEventListener("change", function () {
  const pincode = pincodeDropdown.value;
  if (!pincode) return;

  const url = https://indian-new-pincode-api.p.rapidapi.com/api/Indian-Pincode-Details/?pincode=${pincode};
  fetch(url, {
    method: "GET",
    headers: {
      "x-rapidapi-key": "5c8b6367bcmsh5029a9e076c47e9p119c64jsn75918adf1c3e",
      "x-rapidapi-host": "indian-new-pincode-api.p.rapidapi.com",
    },
  })
    .then((response) => response.json())
    .then((data) => {
      console.log("Selected Pincode Details:", data);

    })
    .catch((err) => {
      console.error("Error fetching pincode details:", err);
    });
});