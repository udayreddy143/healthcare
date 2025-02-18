document.addEventListener("DOMContentLoaded", function () {
    const urlParams = new URLSearchParams(window.location.search);
    const doctorId = urlParams.get("doctorId");

    if (doctorId) {
        fetchSlots(doctorId);
    } else {
        document.getElementById("slotList").innerHTML = "<p>Error: No doctor selected!</p>";
    }
});

function fetchSlots(doctorId) {
    fetch(`http://localhost:8082/appointment/getAppointments/${doctorId}`)
        .then(response => response.json())
        .then(slots => {
            const slotList = document.getElementById("slotList");
            slotList.innerHTML = "";

            if (slots.length === 0) {
                slotList.innerHTML = "<p>No slots available.</p>";
                return;
            }

            slots.forEach(slot => {
                const slotCard = document.createElement("div");
                slotCard.classList.add("slot-card");

                slotCard.innerHTML = `
                    <p><strong>Start Time:</strong> ${new Date(slot.starttime).toLocaleString()}</p>
                    <p><strong>End Time:</strong> ${new Date(slot.endtime).toLocaleString()}</p>
                    <p><strong>Status:</strong> ${slot.status}</p>
                    <button class="book-slot-btn" onclick="bookSlot(${slot.slotid}, ${doctorId})">Book Slot</button>
                `;

                slotList.appendChild(slotCard);
            });
        })
        .catch(error => console.error("Error fetching slots:", error));
}

function bookSlot(slotId, doctorId) {
    const bookingData = {
        slotId: slotId,
        doctorId: doctorId
    };

    fetch("http://localhost:8083/slot/bookslot", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(bookingData)
    })
    .then(response => response.json())
    .then(data => {
        alert(`Booking Successful! Slot ID: ${slotId}`);
        fetchSlots(doctorId);  // Refresh the slots list after booking
    })
    .catch(error => {
        console.error("Error booking slot:", error);
        alert("Error booking the slot. Please try again.");
    });
}
