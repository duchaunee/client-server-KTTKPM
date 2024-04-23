import React, { useEffect, useState } from "react";
import instance from "../../main";
import ModelEdit from "../Model/ModelEdit";
import { confirmAlert } from "react-confirm-alert";
import "react-confirm-alert/src/react-confirm-alert.css"; // Import cs
import toast from "react-hot-toast";
import Model from "../Model/Model";

const Manage = () => {
  const [data, setData] = useState([]);
  const [edit, setEdit] = useState(false);
  const [add, setAdd] = useState(false);

  const [dtEdit, setDtEdit] = useState();

  useEffect(() => {
    const run = async () => {
      const res = await instance.get("/pricingRule");
      console.log("res: ", res);
      setData(res);
      localStorage.setItem("PricingRule", JSON.stringify(res));
    };
    run();
  }, []);

  const handleEdit = (id) => {
    const dt = JSON.parse(localStorage.getItem("PricingRule")).find(
      (item) => item.id === id
    );
    console.log("id - 1: ", id - 1);
    console.log("dt: ", dt);
    setDtEdit(dt);
  };

  console.log("data: ", data);

  return (
    <div>
      <button
        type="button"
        className="text-white bg-blue-700 hover:bg-blue-800 focus:outline-none focus:ring-4 focus:ring-blue-300 font-medium rounded-md text-sm px-5 py-2.5 text-center me-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800 mt-12"
        onClick={() => setAdd(true)}
      >
        Add a Pricing Rule
      </button>
      <div className="relative overflow-x-auto shadow-lg sm:rounded-lg mt-8">
        <table className="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
          <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <tr className="bg-slate-200 font-bold">
              <th scope="col" className="px-6 py-3 text-center">
                ID
              </th>
              <th scope="col" className="px-6 py-3 text-center">
                Min_usage
              </th>
              <th scope="col" className="px-6 py-3 text-center">
                Max_usage
              </th>
              <th scope="col" className="px-6 py-3 text-center">
                Price
              </th>
              <th scope="col" className="px-6 py-3 text-center">
                Service
              </th>
              <th scope="col" className="px-6 py-3 text-center">
                Edit
              </th>
              <th scope="col" className="px-6 py-3 text-center">
                Delete
              </th>
            </tr>
          </thead>
          <tbody>
            {data.map((item) => {
              return (
                <tr
                  key={item.id}
                  className="odd:bg-white odd:dark:bg-gray-900 even:bg-gray-50 even:dark:bg-gray-800 border-b dark:border-gray-700 "
                >
                  <th
                    scope="row"
                    className="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white text-center"
                  >
                    {item.id}
                  </th>
                  <td className="px-6 py-4 text-center">{item.min_usage}</td>
                  <td className="px-6 py-4 text-center">{item.max_usage}</td>
                  <td className="px-6 py-4 text-center">{item.price}</td>
                  <td className="px-6 py-4 text-center">
                    {item.water_service?.service_name || "empty"}
                  </td>
                  <td className="px-6 py-4 text-center">
                    <a
                      className="font-medium text-blue-600 dark:text-blue-500 hover:underline cursor-pointer"
                      onClick={() => {
                        handleEdit(item.id);
                        setEdit(true);
                      }}
                    >
                      Edit
                    </a>
                  </td>
                  <td className="px-6 py-4 text-center">
                    <a
                      className="font-medium text-red-600 dark:text-blue-500 hover:underline cursor-pointer"
                      onClick={() => {
                        console.log("click");
                        confirmAlert({
                          title: "Xác nhận xoá ?",
                          message:
                            "Bạn có chắc chắn muốn xoá PricingRule id = " +
                            item.id,
                          closeOnClickOutside: true,
                          buttons: [
                            {
                              label: "Cancel",
                              onClick: () => {},
                            },
                            {
                              label: "Delete",
                              onClick: async () => {
                                await instance.delete(
                                  `/deletePricingRule/${item.id}`
                                );
                                location.reload();
                                toast.success("Delete successfully !");
                              },
                            },
                          ],
                        });
                      }}
                    >
                      Delete
                    </a>
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
      {/* ============== */}
      {edit && (
        <ModelEdit edit={edit} setEdit={setEdit} dtEdit={dtEdit}></ModelEdit>
      )}
      {add && <Model add={add} setAdd={setAdd}></Model>}
    </div>
  );
};

export default Manage;
