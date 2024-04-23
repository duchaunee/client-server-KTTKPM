import { useEffect, useState } from "react";
import Close from "../../assets/icon/Close";
import instance from "../../main";
import { useNavigate } from "react-router-dom";
import _ from "lodash";
import toast from "react-hot-toast";

const ModelEdit = ({ edit, setEdit, dtEdit }) => {
  // console.log("dtEdit: ", dtEdit);
  const [dt, setDt] = useState();
  const [listService, setListService] = useState();
  const navigate = useNavigate();

  const handleEdit = async () => {
    // console.log(dt);
    if (dt.min_usage && dt.max_usage && dt.price && dt.water_service_id) {
      await instance.put(`/updatePricingRule/${dt.id}`, _.omit(dt, "id"));
      location.reload();
      toast.success("Edit successfully !");
    } else toast.error("Vui lòng điền vào cái trường");
    // setTimeout(() => {
    //   setLoading(false);
    //   navigfate("/home");
    //   localStorage.setItem("employee", JSON.stringify(employee.employee));
    //   toast.success("Login success!");
    // }, 1500);
  };

  const handleChange = (e) => {
    setDt({
      ...dt,
      [e.target.name]: parseFloat(e.target.value) || "",
    });
  };
  // console.log("dt: ", dt);

  // // const pricingRule = JSON.parse(localStorage.getItem("PricingRule"));

  useEffect(() => {
    setDt({
      id: dtEdit?.id,
      min_usage: dtEdit?.min_usage,
      max_usage: dtEdit?.max_usage,
      price: dtEdit?.price,
      water_service_id: dtEdit?.water_service?.id,
    });
  }, []);

  useEffect(() => {
    const run = async () => {
      const allWaterService = await instance.get("/waterservice");
      // console.log("allWaterService: ", allWaterService);
      setListService(allWaterService);
    };
    run();
  }, []);

  // console.log(listService);

  return (
    <div>
      <div
        id="static-modal"
        data-modal-backdrop="static"
        tabIndex={-1}
        aria-hidden="true"
        className={`fixed top-0 right-0 left-0 z-50  w-full md:inset-0 h-full max-h-full bg-opacity-50 bg-black flex items-center justify-center ${
          edit || "hidden"
        }`}
      >
        <div className=" mt-20 bg-black bg-opacity-70 p-10 rounded-md w-[300px] relative">
          <div className="mb-6 ">
            <label
              htmlFor="default-input"
              className="block mb-2 text-sm font-medium  text-white"
            >
              Min usage:
            </label>
            <input
              type="text"
              name="min_usage"
              // eslint-disable-next-line react/prop-types
              value={dt?.min_usage}
              id="default-input"
              className="bg-gray-50 border border-gray-300  text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400  dark:focus:ring-blue-500 dark:focus:border-blue-500 text-black font-bold text-[16px]"
              onChange={handleChange}
            />
          </div>
          <div className="mb-6 ">
            <label
              htmlFor="default-input"
              className="block mb-2 text-sm font-medium  text-white"
            >
              Max usage:
            </label>
            <input
              type="text"
              name="max_usage"
              id="default-input"
              value={dt?.max_usage}
              className="bg-gray-50 border border-gray-300  text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400  dark:focus:ring-blue-500 dark:focus:border-blue-500 text-black font-bold text-[16px]"
              onChange={handleChange}
            />
          </div>
          <div className="mb-6 ">
            <label
              htmlFor="default-input"
              className="block mb-2 text-sm font-medium  text-white"
            >
              Price
            </label>
            <input
              type="text"
              id="default-input"
              name="price"
              value={dt?.price}
              className="bg-gray-50 border border-gray-300  text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400  dark:focus:ring-blue-500 dark:focus:border-blue-500 text-black font-bold text-[16px]"
              onChange={handleChange}
            />
          </div>
          <div className="mb-6 ">
            <label
              htmlFor="default-input"
              className="block mb-2 text-sm font-medium  text-white"
            >
              Service name
            </label>
            <div className="max-w-sm mx-auto">
              <select
                id="countries"
                name="water_service_id"
                onChange={handleChange}
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              >
                <option selected value="">
                  Choose a service name
                </option>
                {/* {console.log("listService: ", listService)} */}
                {console.log("dt: ", dt)}
                {listService?.map((item) => (
                  <option
                    key={item.id}
                    value={item.id}
                    selected={dt?.water_service_id === item?.id ? true : false}
                  >
                    {item.service_name}
                  </option>
                ))}
                {/* <option selected>Choose a country</option>
                <option value="US">United States</option>
                <option value="CA">Canada</option>
                <option value="FR">France</option>
                <option value="DE">Germany</option> */}
              </select>
            </div>

            {/* <input
              type="text"
              id="default-input"
              className="bg-gray-50 border border-gray-300  text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 text-black font-bold text-[16px]"
              onChange={handleChange}
            /> */}
          </div>
          <button
            type="button"
            className="text-white bg-blue-700 hover:bg-blue-800 focus:outline-none focus:ring-4 focus:ring-blue-300 font-medium rounded-md text-sm px-5 py-2.5 text-center  dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800 w-full"
            onClick={handleEdit}
          >
            Update a Pricing Rule
          </button>
          <div
            className="absolute top-2 right-2"
            onClick={() => setEdit(false)}
          >
            <Close></Close>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ModelEdit;
