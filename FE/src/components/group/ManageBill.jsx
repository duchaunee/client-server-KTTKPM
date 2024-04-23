import React, { useEffect, useState } from "react";
import instance from "../../main";
import ModelEdit from "../Model/ModelEdit";
import { confirmAlert } from "react-confirm-alert";
import "react-confirm-alert/src/react-confirm-alert.css"; // Import cs
import toast from "react-hot-toast";

const ManageBill = () => {
  const [data, setData] = useState([]);
  const [customers, setCustomers] = useState([]);
  const employee = JSON.parse(localStorage.getItem("employee"));
  console.log("employee: ", {
    ...data,
    employee_id: employee?.id,
  });
  // const [edit, setEdit] = useState(false);

  // const [dtEdit, setDtEdit] = useState();

  // useEffect(() => {
  //   const run = async () => {
  //     const res = await instance.get("/pricingRule");
  //     console.log("res: ", res);
  //     setData(res);
  //     localStorage.setItem("PricingRule", JSON.stringify(res));
  //   };
  //   run();
  // }, []);

  const handleSaveBill = async () => {
    if (!data.payment || !data.customer_id) {
      toast.error("Vui lòng nhập vào các trường");
      return;
    }
    const res = await instance.post("/insert/bill", {
      ...data,
      employee_id: employee.id,
    });
    console.log("res: ", res);
    if (!res)
      toast.error("Khách hàng chưa khai báo số nước (water_service table)");
    else {
      toast.success("Save bill successfully !");
      setData({
        customer_id: "",
        payment: "",
      });
    }
  };

  useEffect(() => {
    const run = async () => {
      const res = await instance.get("/customer");
      setCustomers(res);
    };
    run();
  }, []);

  const handleChange = (e) => {
    setData({
      ...data,
      [e.target.name]:
        e.target.name === "customer_id"
          ? Number(e.target.value)
          : e.target.value,
    });
  };

  // console.log("data: ", data);

  return (
    <>
      <div
        id="static-modal"
        data-modal-backdrop="static"
        tabIndex={-1}
        aria-hidden="true"
        className={` w-full md:inset-0 h-full max-h-full flex items-center justify-center flex-col`}
      >
        <p className="mt-20 mb-[-20px] text-[20px]">
          Nhập vào thông tin khách hàng
        </p>
        <div className=" p-10 rounded-md w-[300px] relative">
          <div className="mb-6 ">
            <label
              htmlFor="default-input"
              className="block mb-2 text-sm font-medium text-black"
            >
              Employee
            </label>
            <input
              type="text"
              name="employee_id"
              id="default-input"
              value={employee?.name}
              readOnly
              disabled
              className="bg-gray-50 border border-gray-300  text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400  dark:focus:ring-blue-500 dark:focus:border-blue-500  font-bold text-[16px] text-gray-400"
              onChange={handleChange}
            />
          </div>
          <div className="mb-6 ">
            <label
              htmlFor="default-input"
              className="block mb-2 text-sm font-medium  text-black"
            >
              Payment
            </label>
            <input
              value={data?.payment}
              type="text"
              name="payment"
              id="default-input"
              className="bg-gray-50 border border-gray-300  text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400  dark:focus:ring-blue-500 dark:focus:border-blue-500 text-black font-bold text-[16px]"
              onChange={handleChange}
            />
          </div>
          <div className="mb-6 ">
            <label
              htmlFor="default-input"
              className="block mb-2 text-sm font-medium  text-black"
            >
              Customer
            </label>
            {/* <input
              type="text"
              id="default-input"
              name="price"
              className="bg-gray-50 border border-gray-300  text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400  dark:focus:ring-blue-500 dark:focus:border-blue-500 text-black font-bold text-[16px]"
              onChange={handleChange}
            /> */}
            <div className="max-w-sm mx-auto">
              <select
                id="countries"
                name="customer_id"
                onChange={handleChange}
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              >
                <option selected value="">
                  Choose a customer
                </option>
                {customers?.map((item) => (
                  <option
                    key={item.id}
                    value={item.id}
                    selected={data.customer_id === item.id}
                  >
                    {item.name}
                  </option>
                ))}
                {/* <option selected>Choose a country</option>
                <option value="US">United States</option>
                <option value="CA">Canada</option>
                <option value="FR">France</option>
                <option value="DE">Germany</option> */}
              </select>
            </div>
          </div>

          <button
            type="button"
            className="text-white bg-blue-700 hover:bg-blue-800 focus:outline-none focus:ring-4 focus:ring-blue-300 font-medium rounded-md text-sm px-5 py-2.5 text-center  dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800 w-full"
            onClick={handleSaveBill}
          >
            Add a Bill
          </button>
        </div>
      </div>
    </>
  );
};

export default ManageBill;
