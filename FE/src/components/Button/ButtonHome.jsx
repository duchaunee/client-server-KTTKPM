import { useState } from "react";
import Manage from "../group/Manage";
import Model from "../Model/Model";
import ModelEdit from "../Model/ModelEdit";
import ManageBill from "../group/ManageBill";
import Revenue from "../group/Revenue";

const ButtonHome = () => {
  const [activeTab, setActiveTab] = useState(1);

  return (
    <div>
      {/* 3 Button */}
      <div
        className="inline-flex rounded-md shadow-sm text-[20px]"
        role="group"
      >
        <button
          type="button"
          className={`inline-flex items-center px-4 py-2 text-sm font-medium text-gray-900 border border-gray-200 rounded-s-lg hover:bg-gray-100 hover:text-blue-700  dark:bg-gray-800 dark:border-gray-700 dark:text-white dark:hover:text-white dark:hover:bg-gray-700 dark:focus:ring-blue-500 dark:focus:text-white  shadow-md ${
            activeTab === 1 && "z-10 ring-2 ring-blue-700 text-blue-700"
          }`}
          onClick={() => setActiveTab(1)}
        >
          <svg
            className="w-3 h-3 me-2"
            aria-hidden="true"
            xmlns="http://www.w3.org/2000/svg"
            fill="currentColor"
            viewBox="0 0 20 20"
          >
            <path d="M10 0a10 10 0 1 0 10 10A10.011 10.011 0 0 0 10 0Zm0 5a3 3 0 1 1 0 6 3 3 0 0 1 0-6Zm0 13a8.949 8.949 0 0 1-4.951-1.488A3.987 3.987 0 0 1 9 13h2a3.987 3.987 0 0 1 3.951 3.512A8.949 8.949 0 0 1 10 18Z" />
          </svg>
          <p className="select-none">
            Quản lý các mức luỹ tiến và bảng giá tương ứng
          </p>
        </button>
        <button
          type="button"
          className={`inline-flex items-center px-4 py-2 text-sm font-medium text-gray-900 border border-gray-200  hover:bg-gray-100 hover:text-blue-700  dark:bg-gray-800 dark:border-gray-700 dark:text-white dark:hover:text-white dark:hover:bg-gray-700 dark:focus:ring-blue-500 dark:focus:text-white  shadow-md ${
            activeTab === 2 && "z-10 ring-2 ring-blue-700 text-blue-700"
          }`}
          onClick={() => setActiveTab(2)}
        >
          <svg
            className="w-3 h-3 me-2"
            aria-hidden="true"
            xmlns="http://www.w3.org/2000/svg"
            fill="currentColor"
            viewBox="0 0 20 20"
          >
            <path d="M14.707 7.793a1 1 0 0 0-1.414 0L11 10.086V1.5a1 1 0 0 0-2 0v8.586L6.707 7.793a1 1 0 1 0-1.414 1.414l4 4a1 1 0 0 0 1.416 0l4-4a1 1 0 0 0-.002-1.414Z" />
            <path d="M18 12h-2.55l-2.975 2.975a3.5 3.5 0 0 1-4.95 0L4.55 12H2a2 2 0 0 0-2 2v4a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-4a2 2 0 0 0-2-2Zm-3 5a1 1 0 1 1 0-2 1 1 0 0 1 0 2Z" />
          </svg>
          <p className="select-none">Thống kê doanh thu</p>
        </button>
        <button
          type="button"
          className={`inline-flex items-center px-4 py-2 text-sm font-medium text-gray-900 border border-gray-200 rounded-e-lg hover:bg-gray-100 hover:text-blue-700  dark:bg-gray-800 dark:border-gray-700 dark:text-white dark:hover:text-white dark:hover:bg-gray-700 dark:focus:ring-blue-500 dark:focus:text-white  shadow-md ${
            activeTab === 3 && "z-10 ring-2 ring-blue-700 text-blue-700"
          }`}
          onClick={() => setActiveTab(3)}
        >
          <svg
            className="w-3 h-3 me-2"
            aria-hidden="true"
            xmlns="http://www.w3.org/2000/svg"
            fill="currentColor"
            viewBox="0 0 20 20"
          >
            <path d="M14.707 7.793a1 1 0 0 0-1.414 0L11 10.086V1.5a1 1 0 0 0-2 0v8.586L6.707 7.793a1 1 0 1 0-1.414 1.414l4 4a1 1 0 0 0 1.416 0l4-4a1 1 0 0 0-.002-1.414Z" />
            <path d="M18 12h-2.55l-2.975 2.975a3.5 3.5 0 0 1-4.95 0L4.55 12H2a2 2 0 0 0-2 2v4a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-4a2 2 0 0 0-2-2Zm-3 5a1 1 0 1 1 0-2 1 1 0 0 1 0 2Z" />
          </svg>
          <p className="select-none">
            Nhận thanh toán hàng tháng từ khách hàng
          </p>
        </button>
      </div>

      {activeTab === 1 && <Manage></Manage>}
      {activeTab === 2 && <Revenue></Revenue>}
      {activeTab === 3 && <ManageBill></ManageBill>}
    </div>
  );
};

export default ButtonHome;
