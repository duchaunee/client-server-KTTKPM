import React, { useEffect, useRef, useState } from "react";
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
} from "chart.js";
import { Bar } from "react-chartjs-2";
import instance from "../../main";
import Input from "../Input/Input";
import { format } from "date-fns";
import ManageRevenune from "./ManageRevenune";

ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
);

const options = {
  responsive: true,
  plugins: {
    legend: {
      position: "top",
    },
  },
};

const Revenue = () => {
  const revenue = useRef(); //to save data core trả về từ server
  const [labels, setLabels] = useState([
    "Tháng 1",
    "Tháng 2",
    "Tháng 3",
    "Tháng 4",
  ]);
  const [data, setData] = useState([1, 2, 3, 4]);
  const [result, setResult] = useState([]);
  const [select, setSelect] = useState("month");
  //
  const [trigger, setTrigger] = useState(false);

  // Tạo bộ lọc để phân nhóm dữ liệu theo tháng, quý hoặc năm
  const groupDataByFilter = (data, filterType) => {
    const groupedData = {};

    data.forEach((item) => {
      const date = new Date(item.time);
      // console.log("date: ", date);
      let key;

      if (filterType === "month") {
        key = "Month: " + format(date, "MM/yyyy"); // Phân nhóm theo tháng
      } else if (filterType === "quarter") {
        const quarter = Math.floor((date.getMonth() + 3) / 3); // Tính quý
        key = `Quarter: ${quarter}/${date.getFullYear()}`; // Phân nhóm theo quý
      } else if (filterType === "year") {
        key = "Year: " + date.getFullYear().toString(); // Phân nhóm theo năm
      }

      if (!groupedData[key]) {
        groupedData[key] = [];
      }

      groupedData[key].push(item);
    });

    return groupedData;
  };

  useEffect(() => {
    const run = async () => {
      const res = await instance.get("/revenue");
      if (res) {
        revenue.current = res.sort((a, b) => {
          const dateA = new Date(a.time);
          const dateB = new Date(b.time);
          return dateA - dateB;
        });

        console.log("res: ", res);
        setResult(groupDataByFilter(revenue.current, select));
        handleRevenue(groupDataByFilter(revenue.current, select)); //goi 1 lan luc vao trang
        setTrigger((prev) => !prev);
      }
    };
    run();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  useEffect(() => {
    revenue.current && setResult(groupDataByFilter(revenue.current, select));
  }, [select]);

  const handleRevenue = (result) => {
    setLabels(Object.keys(result));
    // setData();
    let arr = [];
    Object.entries(result).forEach(([k, v]) => {
      let total = 0;
      v.forEach((revenueDTO) => {
        total += revenueDTO.total_money;
      });
      arr.push(total);
    });
    setData(arr);
  };

  const data_fill = {
    labels,
    datasets: [
      {
        label: "Doanh thu (VNĐ)",
        data: data,
        backgroundColor: "rgba(53, 162, 235, 0.6",
      },
    ],
  };

  return (
    <div className="flex items-center justify-center mt-10 flex-col">
      <div className="flex gap-8 mb-6">
        <Input
          setSelect={setSelect}
          handleRevenue={handleRevenue}
          result={result}
          setTrigger={setTrigger}
        >
          Select time period
        </Input>
      </div>
      <Bar options={options} data={data_fill} />
      <ManageRevenune trigger={trigger} result={result}></ManageRevenune>
    </div>
  );
};

export default Revenue;
